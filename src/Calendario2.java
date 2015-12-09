import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.imgscalr.Scalr;

public class Calendario2 extends JPanel {
    
    JLabel titulo = new JLabel();
    JPanel primary = new JPanel();
    JPanel secondary = new JPanel();
    
    int width = 350;
    int height = 275;
    int widthPrimary = 350;
    int heightPrimary = 75;
    int widthSecondary = 350;
    int heightSecondary = 200;
    int posX = 15;
    int posY = 35;
    int realDay;
    int realMonth;
    int realYear;
    int nod;
    int som;
    
    String[] headers = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
    String[] months =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    private Color primaryColor = new Color(16, 23, 77);
    Color secondaryColor = new Color(42, 52, 147);
    Color primaryText = new Color(255, 255, 255);
    Color secondaryText = new Color(156, 166, 202);
    
    Font primaryFont = new Font("Century Gothic", Font.BOLD, 14);
    Font secondaryFont = new Font("Century Gothic", Font.BOLD, 12);
    
    public Calendario2() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        primary.setLayout(null);
        primary.setBounds(0, 0, widthPrimary, heightPrimary);
        primary.setBackground(primaryColor);
        add(primary);
        
        secondary.setLayout(null);
        secondary.setBounds(0, heightPrimary, widthSecondary, heightSecondary);
        secondary.setBackground(secondaryColor);
        add(secondary);
        
        titulo.setFont(primaryFont);
        titulo.setForeground(primaryText);
        titulo.setBounds(posX+5, 10, width, 30);
        primary.add(titulo);
        
        for (String s : headers){
            JLabel label = new JLabel(s.toUpperCase(), JLabel.CENTER);
            label.setFont(secondaryFont);
            label.setForeground(secondaryText);
            label.setBounds(posX, posY, 40, 40);
            primary.add(label);
            posX += 47;
        }
        
        posX = 15;
        posY = 5;
        
        GregorianCalendar cal = new GregorianCalendar(); 
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); 
        realMonth = cal.get(GregorianCalendar.MONTH); 
        realYear = cal.get(GregorianCalendar.YEAR); 

        titulo.setText(months[realMonth].toUpperCase()+" "+realYear);

        GregorianCalendar cal2 = new GregorianCalendar(realYear, realMonth, 1);
        nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal2.get(GregorianCalendar.DAY_OF_WEEK)-1;
        posX = som*47+15;

        for (int i=1; i<=nod; i++){
            JLabel label = new JLabel(String.valueOf(i), JLabel.CENTER);
            label.setFont(secondaryFont);
            if(i < realDay) {
                label.setForeground(secondaryText);
            } else label.setForeground(primaryText);
            if(i == realDay) {
                try {
                    label.setHorizontalTextPosition(JLabel.CENTER);
                    BufferedImage Image = ImageIO.read(getClass().getResource("imagens/calendario2/currentBackground.png"));
                    BufferedImage resizedImage = Scalr.resize(Image, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 40, 30, Scalr.OP_ANTIALIAS);
                    label.setIcon(new ImageIcon(resizedImage));
                } catch (IOException ex) {
                    Logger.getLogger(Calendario2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            label.setBounds(posX, posY, 40, 30);
            secondary.add(label);
            posX += 47;
            if(posX >= width-50) {
                posX = 15;
                posY += 40;
            }
        }
    }
    
    public void setHeaders(String[] headers) { this.headers = headers; }
    public void setMonths(String[] months) { this.months = months; }
    public void setPrimaryFont(Font primaryFont) { this.primaryFont = primaryFont; }
    public void setSecondaryFont(Font secondaryFont) { this.secondaryFont = secondaryFont; }
    public void setPrimaryColor(Color primaryColor) { this.primaryColor = primaryColor; }
    public void setSecondaryColor(Color secondaryColor) { this.secondaryColor = secondaryColor; }
    public void setPrimaryText(Color primaryText) { this.primaryText = primaryText; }
    public void setSecondaryText(Color secondaryText) { this.secondaryText = secondaryText; }
    
    
    public String[] getHeaders() { return headers; }
    public String[] getMonths() { return months; }
    public Font getPrimaryFont() { return primaryFont; }
    public Font getSecondaryFont() { return secondaryFont; }
    public Color getPrimaryColor() { return primaryColor; }
    public Color getSecondaryColor() { return secondaryColor; }
    public Color getPrimaryText() { return primaryText; }
    public Color getSecondaryText() { return secondaryText; }
}