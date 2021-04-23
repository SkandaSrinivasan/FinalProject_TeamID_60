/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Patient;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.Patient;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Skanda
 */
public class CovidTestPanel extends javax.swing.JPanel {

    /**
     * Creates new form CovidTestPanel
     */
    EcoSystem system;
    Patient pat;
    UserAccount ua;
    public CovidTestPanel(EcoSystem system,UserAccount ua) {
        initComponents();
        this.system = system;
        pat= null;
        for (Network net : system.getNetworkMap().values()) {
            for (Patient p : net.getPatientDirectory().getPatients()) {
                if (p.getUser().equals(ua)) {
                    pat = p;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Covid Tests");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 501, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}