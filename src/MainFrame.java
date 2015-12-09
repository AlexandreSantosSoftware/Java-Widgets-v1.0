public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        calendario1 = new Calendario();
        relogio1 = new Relogio();
        calendario21 = new Calendario2();
        tradutor1 = new Tradutor();
        temporizador1 = new Temporizador();
        relogio21 = new Relogio2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1125, 570));
        setMinimumSize(new java.awt.Dimension(1125, 570));

        jPanel1.setBackground(new java.awt.Color(178, 182, 217));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 570));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 570));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(calendario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 400));
        jPanel1.add(relogio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 425, -1, 150));
        jPanel1.add(calendario21, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));
        jPanel1.add(tradutor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 10, -1, -1));
        jPanel1.add(temporizador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, -1, -1));
        jPanel1.add(relogio21, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
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
    private Calendario calendario1;
    private Calendario2 calendario21;
    private javax.swing.JPanel jPanel1;
    private Relogio relogio1;
    private Relogio2 relogio21;
    private Temporizador temporizador1;
    private Tradutor tradutor1;
    // End of variables declaration//GEN-END:variables
}