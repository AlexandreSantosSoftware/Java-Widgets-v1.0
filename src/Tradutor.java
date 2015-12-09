import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;
import org.imgscalr.Scalr;

public class Tradutor extends JPanel {
    
    JTextField traduzir = new JTextField();
    JLabel titulo = new JLabel();
    JLabel traduzido = new JLabel();
    JPanel primary = new JPanel();
    JPanel secondary = new JPanel();
    JButton doit = new JButton();
    JComboBox language = new JComboBox();
    
    int width = 350;
    int height = 275;
    int widthPrimary = 350;
    int heightPrimary = 100;
    int widthSecondary = 350;
    int heightSecondary = 175;
    
    Color primaryColor = new Color(255, 255, 255);
    Color secondaryColor = new Color(16, 23, 77);
    Color primaryText = new Color(0, 0, 0);
    Color secondaryText = new Color(255, 255, 255);
    Color extraColor = new Color(229, 45, 107);
    
    String clientId = "iot78g234758g324";
    String clientSecret = "ULop183i0VZMAqXn08CjkNLH+ie7DWVbitji+Ej8rZM=";
    
    public Tradutor() {
        setLayout(null);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));
        
        doit.setBounds(width-50, heightPrimary-20, 40, 40);
        doit.setFocusPainted(false);
        doit.setContentAreaFilled(false);
        doit.setIcon(new ImageIcon(getClass().getResource("imagens/tradutor/doit.png")));
        doit.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                doit.setIcon(new ImageIcon(getClass().getResource("imagens/tradutor/doit_hover.png")));
            }
            @Override public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                doit.setIcon(new ImageIcon(getClass().getResource("imagens/tradutor/doit.png")));
            }
        });
        doit.addActionListener((ActionEvent e) -> {
            try {
                Translate.setClientId(clientId); 
                Translate.setClientSecret(clientSecret);
                LanguageItem tl = (LanguageItem) language.getSelectedItem();
                String txt = Translate.execute(traduzir.getText(), Language.AUTO_DETECT, tl.getID());
                traduzido.setText("<html>"+txt+"</html>");
            } catch (Exception ex) {
                Logger.getLogger(Tradutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        add(doit);
        
        primary.setLayout(null);
        primary.setBounds(0, 0, widthPrimary, heightPrimary);
        primary.setBackground(primaryColor);
        add(primary);
        
        secondary.setLayout(null);
        secondary.setBounds(0, heightPrimary, widthSecondary, heightSecondary);
        secondary.setBackground(secondaryColor);
        add(secondary);
        
        titulo.setFont(new Font("Century Gothic", Font.BOLD, 14));
        titulo.setForeground(secondaryColor);
        titulo.setText("TRADUTOR");
        titulo.setBounds(20, 10, width, 30);
        primary.add(titulo);
        
        traduzir.setFont(new Font("Century Gothic", Font.PLAIN, 12));
        traduzir.setForeground(primaryText);
        traduzir.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, extraColor));
        traduzir.setBounds(20, 50, width-40, 25);
        primary.add(traduzir);
        
        traduzido.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        traduzido.setForeground(secondaryText);
        traduzido.setBounds(20, 40, width-40, 115);
        traduzido.setVerticalAlignment(JLabel.TOP);
        secondary.add(traduzido);
        
        language.setBounds(10, 10, width/2, 20);
        language.setOpaque(false);
        language.setRenderer(new DefaultListCellRenderer() {
            @Override public void paint(Graphics g) {
                setBackground(secondaryColor);
                setForeground(secondaryText);
                setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                super.paint(g);
            }
        });
        language.setUI(new BasicComboBoxUI() {
            @Override protected JButton createArrowButton() {
                JButton botao = new JButton();
                botao.setContentAreaFilled(false);
                botao.setBackground(secondaryColor);
                botao.setOpaque(false);
                try {
                    BufferedImage Image = ImageIO.read(getClass().getResource("imagens/tradutor/arrow.png"));
                    BufferedImage resizedImage = Scalr.resize(Image, Scalr.Method.QUALITY, Scalr.Mode.FIT_EXACT, 12, 10, Scalr.OP_ANTIALIAS);
                    botao.setIcon(new ImageIcon(resizedImage));
                } catch (IOException ex) {
                    Logger.getLogger(Tradutor.class.getName()).log(Level.SEVERE, null, ex);
                }
                return botao;
            }
        });
        language.setBorder(null);
        language.setFont(new Font("Century Gothic", Font.BOLD, 14));
        secondary.add(language);
        
        
        language.addItem(new LanguageItem(Language.PORTUGUESE, "Portuguese"));
        language.addItem(new LanguageItem(Language.ARABIC, "Arabic"));
        language.addItem(new LanguageItem(Language.BULGARIAN, "Bulgarian"));
        language.addItem(new LanguageItem(Language.CATALAN, "Catalan"));
        language.addItem(new LanguageItem(Language.CZECH, "Czech"));
        language.addItem(new LanguageItem(Language.DANISH, "Danish"));
        language.addItem(new LanguageItem(Language.DUTCH, "Dutch"));
        language.addItem(new LanguageItem(Language.ENGLISH, "English"));
        language.addItem(new LanguageItem(Language.ESTONIAN, "Estonian"));
        language.addItem(new LanguageItem(Language.FINNISH, "Finnish"));
        language.addItem(new LanguageItem(Language.FRENCH, "French"));
        language.addItem(new LanguageItem(Language.GERMAN, "German"));
        language.addItem(new LanguageItem(Language.GREEK, "Greek"));
        language.addItem(new LanguageItem(Language.HAITIAN_CREOLE, "Haitian Creole"));
        language.addItem(new LanguageItem(Language.HEBREW, "Hebrew"));
        language.addItem(new LanguageItem(Language.HINDI, "Hindi"));
        language.addItem(new LanguageItem(Language.HUNGARIAN, "Hungarian"));
        language.addItem(new LanguageItem(Language.INDONESIAN, "Indonesian"));
        language.addItem(new LanguageItem(Language.ITALIAN, "Italian"));
        language.addItem(new LanguageItem(Language.KOREAN, "Korean"));
        language.addItem(new LanguageItem(Language.LATVIAN, "Latvian"));
        language.addItem(new LanguageItem(Language.LITHUANIAN, "Lithuanian"));
        language.addItem(new LanguageItem(Language.MALAY, "Malay"));
        language.addItem(new LanguageItem(Language.NORWEGIAN, "Norwegian"));
        language.addItem(new LanguageItem(Language.PERSIAN, "Persian"));
        language.addItem(new LanguageItem(Language.POLISH, "Polish"));
        language.addItem(new LanguageItem(Language.ROMANIAN, "Romanian"));
        language.addItem(new LanguageItem(Language.RUSSIAN, "Russian"));
        language.addItem(new LanguageItem(Language.SLOVAK, "Slovak"));
        language.addItem(new LanguageItem(Language.SLOVENIAN, "Slovenian"));
        language.addItem(new LanguageItem(Language.SPANISH, "Spanish"));
        language.addItem(new LanguageItem(Language.SWEDISH, "Swedish"));
        language.addItem(new LanguageItem(Language.THAI, "Thai"));
        language.addItem(new LanguageItem(Language.TURKISH, "Turkish"));
        language.addItem(new LanguageItem(Language.UKRAINIAN, "Ukrainian"));
        language.addItem(new LanguageItem(Language.URDU, "Urdu"));
        language.addItem(new LanguageItem(Language.VIETNAMESE, "Vietnamese"));
    }
    
    class LanguageItem {
        private final Language id;
        private final String value;

        public LanguageItem(Language id, String value) {
            this.value = value;
            this.id = id;
        }

        public Language getID() {
            return this.id;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}