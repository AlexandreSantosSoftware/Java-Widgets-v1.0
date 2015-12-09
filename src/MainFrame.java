import java.awt.Color;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        
        MaterialDesignCalendar.setPrimaryColor(Color.ORANGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MaterialDesignCalendar = new Calendario2();
        MaterialDesignClock = new Relogio2();
        MaterialDesignTimer = new Temporizador();
        MaterialDesignTranslator = new Tradutor();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1125, 570));
        setMinimumSize(new java.awt.Dimension(1125, 570));

        jPanel1.setBackground(new java.awt.Color(178, 182, 217));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 570));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(MaterialDesignCalendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel1.add(MaterialDesignClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        jPanel1.add(MaterialDesignTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));
        jPanel1.add(MaterialDesignTranslator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Calendario2 MaterialDesignCalendar;
    private Relogio2 MaterialDesignClock;
    private Temporizador MaterialDesignTimer;
    private Tradutor MaterialDesignTranslator;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}