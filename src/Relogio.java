import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Relogio extends JPanel {
    
    JLabel horas = new JLabel();
    JLabel data = new JLabel();
    
    int width = 375;
    int height = 155;
    
    String[] headers = {"Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sabado"};
    String[] months =  {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    
    Color corFundo = new Color(240, 114, 64);
    Color corHoras= new Color(255, 255, 255);
    Color corData = new Color(255, 255, 255);
    
    public Relogio() {
        setLayout(null);
        setBackground(corFundo);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        horas.setFont(new Font("Century Gothic", Font.BOLD, 75));
        horas.setForeground(corHoras);
        horas.setHorizontalAlignment(JLabel.CENTER);
        add(horas);
        
        data.setFont(new Font("Century Gothic", Font.BOLD, 14));
        data.setForeground(corData);
        data.setHorizontalAlignment(JLabel.CENTER);
        add(data);
        
        horas.setBounds(0, 25, width, 65);
        data.setBounds(0, 100, width, 30);
        
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
        if(cal.get(GregorianCalendar.SECOND) >= 0 && cal.get(GregorianCalendar.SECOND) <= 9) {
            segundo = "0"+String.valueOf(cal.get(GregorianCalendar.SECOND));
        } else {
            segundo = String.valueOf(cal.get(GregorianCalendar.SECOND));
        }
        horas.setText("<html>"+hora+":"+minuto+"<font size='5'>"+segundo+"</font></html>");
        data.setText(String.valueOf(headers[cal.get(GregorianCalendar.DAY_OF_WEEK)-1])+", "+String.valueOf(cal.get(GregorianCalendar.DAY_OF_MONTH))+" de "+String.valueOf(months[cal.get(GregorianCalendar.MONTH)])+" de "+String.valueOf(cal.get(GregorianCalendar.YEAR)));
    }
}