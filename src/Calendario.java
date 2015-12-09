import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calendario extends JPanel{
    
    JLabel titulo = new JLabel();
    
    int width = 375;
    int height = 385;
    int posX = 15;
    int posY = 75;
    int realDay;
    int realMonth;
    int realYear;
    int nod;
    int som;
    
    String[] headers = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
    String[] months =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    Color corTitulo = new Color(252, 237, 108);
    Color corFundo = new Color(40, 49, 61);
    Color corCabecalho = new Color(152, 152, 152);
    Color corDias = new Color(255, 255, 255);
    Color corDiaAtual = new Color(30, 39, 51);
    
    Font primaryFont = new Font("Berlin Sans FB Demi", Font.BOLD, 26);
    Font secondaryFont = new Font("Century Gothic", Font.BOLD, 14);
    
    public Calendario() {
        setLayout(null);
        setBackground(corFundo);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        titulo.setFont(primaryFont);
        titulo.setForeground(corTitulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        titulo.setBounds(0, 30, width, 30);
        add(titulo);
        
        for (String s : headers){
            JLabel label = new JLabel(s, JLabel.CENTER);
            label.setFont(secondaryFont);
            label.setForeground(corCabecalho);
            label.setBounds(posX, posY, 40, 40);
            add(label);
            posX += 50;
        }

        posX = 15;
        posY += 50;

        GregorianCalendar cal = new GregorianCalendar(); 
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); 
        realMonth = cal.get(GregorianCalendar.MONTH); 
        realYear = cal.get(GregorianCalendar.YEAR); 

        titulo.setText(months[realMonth]+" "+realYear);

        GregorianCalendar cal2 = new GregorianCalendar(realYear, realMonth, 1);
        nod = cal2.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal2.get(GregorianCalendar.DAY_OF_WEEK)-1;
        posX = som*50+15;

        for (int i=1; i<=nod; i++){
            JLabel label = new JLabel(String.valueOf(i), JLabel.CENTER);
            label.setFont(secondaryFont);
            label.setForeground(corDias);
            if(i == realDay) {
                label.setOpaque(true);
                label.setBackground(corDiaAtual);
            }
            label.setBounds(posX, posY, 40, 40);
            add(label);
            posX += 50;
            if(posX >= width-50) {
                posX = 15;
                posY += 50;
            }
        }
    }

    public void setHeaders(String[] headers) { this.headers = headers; }
    public void setMonths(String[] months) { this.months = months; }
    public void setCorTitulo(Color corTitulo) { this.corTitulo = corTitulo; }
    public void setCorFundo(Color corFundo) { this.corFundo = corFundo; }
    public void setCorCabecalho(Color corCabecalho) { this.corCabecalho = corCabecalho; }
    public void setCorDias(Color corDias) { this.corDias = corDias; }
    public void setCorDiaAtual(Color corDiaAtual) { this.corDiaAtual = corDiaAtual; }
    public void setPrimaryFont(Font primaryFont) { this.primaryFont = primaryFont; }
    public void setSecondaryFont(Font secondaryFont) { this.secondaryFont = secondaryFont; }
    
    public String[] getHeaders() { return headers; }
    public String[] getMonths() { return months; }
    public Color getCorTitulo() { return corTitulo; }
    public Color getCorFundo() { return corFundo; }
    public Color getCorCabecalho() { return corCabecalho; }
    public Color getCorDias() { return corDias; }
    public Color getCorDiaAtual() { return corDiaAtual; } 
    public Font getPrimaryFont() { return primaryFont; }
    public Font getSecondaryFont() { return secondaryFont; }
}