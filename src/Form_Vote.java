
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Predator
 */
public class Form_Vote extends javax.swing.JDialog {

    /**
     * Creates new form Form_Vote
     */
    public Form_Vote(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

    public JLabel getLblElectionName() {
        return lblElectionName;
    }

    public JButton getBtnConfirm_Vote() {
        return btnConfirm_Vote;
    }

    public JButton getBtnCancel_Vote() {
        return btnCancel_Vote;
    }

//    public JScrollPane getContentScrollPanel() {
//        return ContentScrollPanel;
//    }

    public JPanel getContentElectionPanel() {
        return ContentElectionPanel;
    }

    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenu1 = new javax.swing.JMenu();
        ButtonPanel = new javax.swing.JPanel();
        btnConfirm_Vote = new javax.swing.JButton();
        btnCancel_Vote = new javax.swing.JButton();
        TitlePanel = new javax.swing.JPanel();
        lblElectionName = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        ContentScrollPanel = new javax.swing.JScrollPane();
        panelScroll = new javax.swing.JPanel();
        ContentElectionPanel = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(724, 553));
        setPreferredSize(new java.awt.Dimension(724, 553));

        btnConfirm_Vote.setText("Confirm");
        ButtonPanel.add(btnConfirm_Vote);

        btnCancel_Vote.setText("Cancel");
        ButtonPanel.add(btnCancel_Vote);

        getContentPane().add(ButtonPanel, java.awt.BorderLayout.PAGE_END);

        TitlePanel.setMinimumSize(new java.awt.Dimension(45, 100));
        TitlePanel.setLayout(new java.awt.BorderLayout());

        lblElectionName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblElectionName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblElectionName.setText("Title");
        lblElectionName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblElectionName.setPreferredSize(new java.awt.Dimension(41, 100));
        TitlePanel.add(lblElectionName, java.awt.BorderLayout.CENTER);

        getContentPane().add(TitlePanel, java.awt.BorderLayout.PAGE_START);

        ContentPanel.setPreferredSize(new java.awt.Dimension(27, 27));
        ContentPanel.setLayout(new java.awt.BorderLayout());

        ContentScrollPanel.setBorder(null);
        ContentScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ContentElectionPanel.setLayout(new javax.swing.BoxLayout(ContentElectionPanel, javax.swing.BoxLayout.Y_AXIS));
        panelScroll.add(ContentElectionPanel);

        ContentScrollPanel.setViewportView(panelScroll);

        ContentPanel.add(ContentScrollPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(ContentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonPanel;
    private javax.swing.JPanel ContentElectionPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JScrollPane ContentScrollPanel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JButton btnCancel_Vote;
    private javax.swing.JButton btnConfirm_Vote;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel lblElectionName;
    private javax.swing.JPanel panelScroll;
    // End of variables declaration//GEN-END:variables
}
