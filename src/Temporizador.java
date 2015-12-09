import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Temporizador extends JPanel {
    
    JLabel titulo = new JLabel();
    JLabel horaRestante = new JLabel();
    JLabel minutoRestante = new JLabel();
    JLabel horas = new JLabel();
    JLabel minutos = new JLabel();
    JPanel primary = new JPanel();
    JPanel secondary = new JPanel();
    
    int width = 350;
    int height = 275;
    int widthPrimary = 175;
    int heightPrimary = 275;
    int widthSecondary = 175;
    int heightSecondary = 275;
    
    Color primaryColor = new Color(40, 53, 147);
    Color secondaryColor = new Color(16, 23, 77);
    Color primaryText = new Color(255, 255, 255);
    
    int interval;
    Timer timer;
    
    public Temporizador() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        primary.setLayout(null);
        primary.setBounds(0, 0, widthPrimary, heightPrimary);
        primary.setBackground(primaryColor);
        add(primary);
        
        secondary.setLayout(null);
        secondary.setBounds(widthPrimary, 0, widthSecondary, heightSecondary);
        secondary.setBackground(secondaryColor);
        add(secondary);
        
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
        titulo.setForeground(primaryText);
        titulo.setText("TEMPORIZADOR");
        titulo.setBounds(20, 10, width, 30);
        primary.add(titulo);
        
        horaRestante.setFont(new Font("Century Gothic", Font.PLAIN, 120));
        horaRestante.setForeground(primaryText);
        horaRestante.setBounds(0, 75, widthPrimary, 100);
        horaRestante.setHorizontalAlignment(JLabel.CENTER);
        horaRestante.setText("10");
        primary.add(horaRestante);
        
        minutoRestante.setFont(new Font("Century Gothic", Font.PLAIN, 120));
        minutoRestante.setForeground(primaryText);
        minutoRestante.setHorizontalAlignment(JLabel.CENTER);
        minutoRestante.setText("00");
        minutoRestante.setBounds(0, 75, widthSecondary, 100);
        secondary.add(minutoRestante);
        
        horas.setFont(new Font("Century Gothic", Font.BOLD, 14));
        horas.setForeground(primaryText);
        horas.setHorizontalAlignment(JLabel.CENTER);
        horas.setText("HORAS");
        horas.setBounds(0, 180, widthPrimary, 30);
        primary.add(horas);
        
        minutos.setFont(new Font("Century Gothic", Font.BOLD, 14));
        minutos.setForeground(primaryText);
        minutos.setHorizontalAlignment(JLabel.CENTER);
        minutos.setText("MINUTOS");
        minutos.setBounds(0, 180, widthSecondary, 30);
        secondary.add(minutos);
        
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval = 36000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override public void run() {
                int secs = setInterval();
                int hours = secs / 3600;
                int minutes = (secs % 3600) / 60;
                horaRestante.setText(String.valueOf(hours));
                minutoRestante.setText(String.valueOf(minutes));
            }
        }, delay, period);
    }
    
    int setInterval() {
        if (interval == 1) timer.cancel();
        return --interval;
    }
}