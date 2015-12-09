import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.imgscalr.Scalr;

public class Relogio2 extends JPanel {
    
    JLabel titulo = new JLabel();
    JLabel horas = new JLabel();
    JLabel data = new JLabel();
    JLabel primaryBackground = new JLabel();
    JLabel secondaryBackground = new JLabel();
    JPanel primary = new JPanel();
    JPanel secondary = new JPanel();
    
    int width = 350;
    int height = 275;
    int widthPrimary = 350;
    int heightPrimary = 138;
    int widthSecondary = 350;
    int heightSecondary = 138;
    
    Color primaryText = new Color(255, 255, 255);
    Color secondaryText = new Color(0, 0, 0);
    
    String[] headers = {"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado"};
    String[] months =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    public Relogio2() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        primary.setLayout(null);
        primary.setBounds(0, 0, widthPrimary, heightPrimary);
        add(primary);
        
        secondary.setLayout(null);
        secondary.setBounds(0, heightPrimary, widthSecondary, heightSecondary);
        add(secondary);
        
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
        titulo.setForeground(secondaryText);
        titulo.setText("PORTUGAL");
        titulo.setBounds(20, 10, width, 30);
        primary.add(titulo);
        
        horas.setFont(new Font("Century Gothic", Font.PLAIN, 65));
        horas.setForeground(primaryText);
        horas.setBounds(10, 25, width, 65);
        secondary.add(horas);
        
        data.setFont(new Font("Century Gothic", Font.BOLD, 14));
        data.setForeground(primaryText);
        data.setBounds(20, 85, width, 30);
        secondary.add(data);
        
        try {
            BufferedImage Image1 = ImageIO.read(getClass().getResource("imagens/relogio2/primaryBackground.png"));
            BufferedImage resizedImage1 = Scalr.resize(Image1, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, widthPrimary, heightPrimary, Scalr.OP_ANTIALIAS);
            primaryBackground.setIcon(new ImageIcon(resizedImage1));
            
            BufferedImage Image2 = ImageIO.read(getClass().getResource("imagens/relogio2/secondaryBackground.png"));
            BufferedImage resizedImage2 = Scalr.resize(Image2, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, widthPrimary, heightPrimary, Scalr.OP_ANTIALIAS);
            secondaryBackground.setIcon(new ImageIcon(resizedImage2));
        } catch (IOException ex) { }
        primaryBackground.setBounds(0, 0, widthPrimary, heightPrimary);
        primary.add(primaryBackground);
        secondaryBackground.setBounds(0, 0, widthSecondary, heightSecondary);
        secondary.add(secondaryBackground);
        
        
        fillInfo();
        new Timer(100, (ActionEvent e) -> {
            fillInfo();
        }).start();
    }
    
    private void fillInfo() {
        String hora;
        String minuto;
        String segundo;
        GregorianCalendar cal = new GregorianCalendar(); 
        if(cal.get(GregorianCalendar.HOUR_OF_DAY) >= 0 && cal.get(GregorianCalendar.HOUR_OF_DAY) <= 9) {
            hora = "0"+String.valueOf(cal.get(GregorianCalendar.HOUR_OF_DAY));
        } else {
            hora = String.valueOf(cal.get(GregorianCalendar.HOUR_OF_DAY));
        }
        if(cal.get(GregorianCalendar.MINUTE) >= 0 && cal.get(GregorianCalendar.MINUTE) <= 9) {
            minuto = "0"+String.valueOf(cal.get(GregorianCalendar.MINUTE));
        } else {
            minuto = String.valueOf(cal.get(GregorianCalendar.MINUTE));
        }
        horas.setText(hora+":"+minuto);
        data.setText(String.valueOf(headers[cal.get(GregorianCalendar.DAY_OF_WEEK)-1])+", "+String.valueOf(cal.get(GregorianCalendar.DAY_OF_MONTH))+" "+String.valueOf(months[cal.get(GregorianCalendar.MONTH)])+" "+String.valueOf(cal.get(GregorianCalendar.YEAR)));
    }
}