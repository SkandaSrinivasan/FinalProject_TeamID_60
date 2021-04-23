/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.VaccineSite;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.CovidCareCenter;
import Business.Organization.Doctor;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.Organization.VaccineSiteOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skanda
 */
public class VaccineAppointmentManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form VaccineAppointmentManagePanel
     */
    EcoSystem system;
    UserAccount ua;
    Patient pat;
    VaccineSiteOrganization org;
    public VaccineAppointmentManagePanel(EcoSystem system,UserAccount ua) {
        this.system = system;
        this.ua = ua;
        initComponents();
        for (Network n : system.getNetworkMap().values()) {
            for (Organization o : n.getVaxCenter().getOrganizationDirectory().getOrgList()) {
                if (o.getType().equals(Organization.Type.VaccineSite) && o.getUser().equals(ua)) {
                    org = (VaccineSiteOrganization) o;                   
                }
            }
        }
        populateTable();
    }
public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
        model.setRowCount(0);
        for (Patient p : org.getPatients()) {
            model.addRow(new Object[]{p.getName(), p.getPatientId(), p.getNetwork().getName(), p.getVaxStatus()});
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
        patientTable = new javax.swing.JTable();
        adminVaccine = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vaccine Administration");

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Patient", "Patient ID#", "Network", "Vaccination Status"
            }
        ));
        jScrollPane1.setViewportView(patientTable);

        adminVaccine.setText("Administer Vaccine");
        adminVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminVaccineActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adminVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adminVaccine)
                .addGap(0, 203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void adminVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminVaccineActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel) patientTable.getModel();
         int row = patientTable.getSelectedRow();
         String patientId = (String)model.getValueAt(row, 1);
         for(Network n:system.getNetworkMap().values()){
             for(Patient p:n.getPatientDirectory().getPatients()){
                 if(p.getPatientId().equals(patientId)){
                     pat = p;
                 }
             }
         }
         pat.setVaxStatus("Vaccinated");
         org.getPatients().remove(pat);
         int stock = 0;
         System.out.println(pat.getRequestedVaccine());
         stock= org.getVaccineStock().get(pat.getRequestedVaccine());
         stock-=1;
         org.getVaccineStock().put(pat.getRequestedVaccine(),stock);
         JOptionPane.showMessageDialog(this, "Vaccination Complete", "Success", JOptionPane.INFORMATION_MESSAGE);
         populateTable();
    }//GEN-LAST:event_adminVaccineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patientTable;
    // End of variables declaration//GEN-END:variables
}
