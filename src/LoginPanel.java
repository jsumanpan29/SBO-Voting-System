
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Predator
 */
public class LoginPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form LOginPanel
     */
    public LoginPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
        public class LoginWorker extends SwingWorker<Boolean, Boolean> {

            private String userName;
            private char[] password;

            public LoginWorker(String userName, char[] password) {
                this.userName = userName;
                this.password = password;
            }

            @Override
            protected Boolean doInBackground() throws Exception {
                // Do you background work here, query the database, compare the values...
                Thread.sleep(2000);
//                return Math.round((Math.random() * 1)) == 0 ? new Boolean(true) : new Boolean(false);
                return new Boolean(true);
            }

            @Override
            protected void done() {
                System.out.println("Done...");
                try {
//                    if (get()) {
//                        JOptionPane.showMessageDialog(LoginPane.this, "Login sucessful");
//                    } else {
//                        JOptionPane.showMessageDialog(LoginPane.this, "Login failed");
//                    }
//                    userNameField.setEnabled(true);
//                    passwordField.setEnabled(true);
//                    okay.setEnabled(true);
//                    cancel.setEnabled(true);
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }

        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
