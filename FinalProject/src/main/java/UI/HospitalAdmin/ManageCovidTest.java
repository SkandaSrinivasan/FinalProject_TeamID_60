/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.HospitalAdmin;

import Business.Components.VaccineSupplyRequest;
import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.CovidCareCenter;
import Business.Organization.CovidTest;
import Business.Organization.Organization;
import Business.Organization.VaccineSupplierOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skanda
 */
public class ManageCovidTest extends javax.swing.JPanel {

    /**
     * Creates new form ManageCovidTest
     */
    EcoSystem system;
    UserAccount ua;
    CovidCareCenter c;
    public ManageCovidTest(EcoSystem system,UserAccount ua) {
        initComponents();
        this.system = system;
        this.ua = ua;
        System.out.println("Bug Test"+ua.getUserName());
        for (Network n : system.getNetworkMap().values()) {
            for (Organization o : n.getCovidCare().getOrganizationDirectory().getOrgList()) {
                System.out.println(o.getName()+o.getUser().getUserName()+ua);
                if (o.getUser()!=null && o.getType().equals(Organization.Type.CovidCareCenter) && o.getUser().equals(ua)) {
                    c = (CovidCareCenter) o;                    
                }
            }
        }
        System.out.println("Bug Test"+ua.getUserName());
        populateTable();
    }

        public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) testTable.getModel();
        model.setRowCount(0);
        for (CovidTest t : c.getCovidTests()) {
            model.addRow(new Object[]{t.getTestingPatient().getPatientId(),t.getReferringDoctor().getFullName(),t.getType(),t.getOutcome()});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        testTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(0, 184, 148));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COVID TEST MANAGEMENT");
        jLabel1.setOpaque(true);

        testTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PatientID#", "Ordered Doctor", "Test Type", "Outcome"
            }
        ));
        jScrollPane1.setViewportView(testTable);

        jButton1.setBackground(new java.awt.Color(231, 76, 60));
        jButton1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Mark Positive");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 184, 148));
        jButton2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Mark Negative");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1073, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 212, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int row = testTable.getSelectedRow();
        if(row>=0){
            CovidTest test = c.getCovidTests().get(row);
            if(test.getOutcome().equals("Pending")){
                test.setOutcome("Positive");
                test.getTestingPatient().setCovidStatus("Infected");
            }
                
            else{
               JOptionPane.showMessageDialog(this, "Test is already complete", "FAIL", JOptionPane.ERROR_MESSAGE);  
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select a Test to complete", "Pass", JOptionPane.INFORMATION_MESSAGE);
        }
        populateTable();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row = testTable.getSelectedRow();
        if(row>=0){
            CovidTest test = c.getCovidTests().get(row);
            if(test.getOutcome().equals("Pending")){
                test.setOutcome("Negative");
                
            }
            else{
               JOptionPane.showMessageDialog(this, "Test is already complete", "FAIL", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Please select a Test to complete", "Pass", JOptionPane.INFORMATION_MESSAGE);
        }
        populateTable();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable testTable;
    // End of variables declaration//GEN-END:variables
}
