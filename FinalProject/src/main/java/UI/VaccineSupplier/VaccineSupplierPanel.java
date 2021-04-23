/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.VaccineSupplier;

import Business.Components.VaccineSupplyRequest;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.Organization.VaccineSupplierOrganization;
import Business.UserAccount.UserAccount;
import com.finalproject.finalproject.LoginPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skanda
 */
public class VaccineSupplierPanel extends javax.swing.JPanel {

    /**
     * Creates new form VaccineSupplierPanel
     */
    EcoSystem system;
    UserAccount ua;
    VaccineSupplierOrganization org;
private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public VaccineSupplierPanel(EcoSystem system, UserAccount ua) {
        initComponents();
        this.system = system;
        this.ua = ua;
        for (Network n : system.getNetworkMap().values()) {
            for (Organization o : n.getVaxCenter().getOrganizationDirectory().getOrgList()) {
                if (o.getType().equals(Organization.Type.VaccineSupplier) && o.getUser().equals(ua)) {
                    org = (VaccineSupplierOrganization) o;
                }
            }
        }
        updateCounts();
        populateTable();
    }

    public void updateCounts() {
        txtPfizer.setText(String.valueOf(org.getPfizerDoses()));
        txtModerna.setText(String.valueOf(org.getModernaDoses()));
        txtJJ.setText(String.valueOf(org.getModernaDoses()));
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) reqTable.getModel();
        model.setRowCount(0);
        for (VaccineSupplyRequest p : org.getRequests()) {
            model.addRow(new Object[]{p.getSite().getName(), p.getRequestedVaccine(), p.getDosesRequired(),p.getStatus()});
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPfizer = new javax.swing.JTextField();
        txtModerna = new javax.swing.JTextField();
        txtJJ = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        reqTable = new javax.swing.JTable();
        completeSupply = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaccine Supply Management");

        jLabel2.setText("Pfizer Doses Remaining:");

        jLabel3.setText("Moderna Doses Remaining:");

        jLabel4.setText("J&J Doses Remaining:");

        reqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine Site", "Vaccine Type", "Doses Requested", "Request Status"
            }
        ));
        jScrollPane1.setViewportView(reqTable);

        completeSupply.setText("Complete Supply Request");
        completeSupply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeSupplyActionPerformed(evt);
            }
        });

        jButton1.setText("LogOut");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPfizer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtModerna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(completeSupply, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPfizer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtModerna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtJJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(completeSupply)
                .addGap(0, 100, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void completeSupplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeSupplyActionPerformed
        // TODO add your handling code here:
        int row = reqTable.getSelectedRow();
        if (row >= 0) {
            
            VaccineSupplyRequest r = org.getRequests().get(row);
            if(r.getStatus().equals("Fulfilled")){
                JOptionPane.showMessageDialog(this, "Request already filled", "FAIL", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (r.getRequestedVaccine().equals("Pfizer")) {
                if (org.getPfizerDoses() > Integer.parseInt(r.getDosesRequired())) {
                    r.getSite().getVaccineStock().put("Pfizer", org.getPfizerDoses() - Integer.parseInt(r.getDosesRequired()));
                    org.setPfizerDoses(org.getPfizerDoses() - Integer.parseInt(r.getDosesRequired()));
                    r.setStatus("Fulfilled");
                    JOptionPane.showMessageDialog(this, "Request Fulfilled successfully", "Pass", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Supply of the requested vaccine", "fail", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (r.getRequestedVaccine().equals("Moderna")) { 
                if (org.getModernaDoses() > Integer.parseInt(r.getDosesRequired())) {
                    r.getSite().getVaccineStock().put("Moderna", org.getModernaDoses() - Integer.parseInt(r.getDosesRequired()));
                    org.setModernaDoses(org.getModernaDoses() - Integer.parseInt(r.getDosesRequired()));
                    r.setStatus("Fulfilled");
                    JOptionPane.showMessageDialog(this, "Request Fulfilled successfully", "Pass", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Supply of the requested vaccine", "fail", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (r.getRequestedVaccine().equals("J&J")) {
                if (org.getJjDoses() > Integer.parseInt(r.getDosesRequired())) {
                    r.getSite().getVaccineStock().put("J&J", org.getJjDoses() - Integer.parseInt(r.getDosesRequired()));
                    r.setStatus("Fulfilled");
                    org.setJjDoses(org.getJjDoses() - Integer.parseInt(r.getDosesRequired()));
                    JOptionPane.showMessageDialog(this, "Request Fulfilled successfully", "Pass", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient Supply of the requested vaccine", "fail", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request to fulfill", "fail", JOptionPane.ERROR_MESSAGE);
        }
        updateCounts();
        populateTable();
    }//GEN-LAST:event_completeSupplyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.setContentPane(new LoginPanel(this.system));
        topFrame.revalidate();
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton completeSupply;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reqTable;
    private javax.swing.JTextField txtJJ;
    private javax.swing.JTextField txtModerna;
    private javax.swing.JTextField txtPfizer;
    // End of variables declaration//GEN-END:variables
}
