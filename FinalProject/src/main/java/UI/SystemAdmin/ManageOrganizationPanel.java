/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdmin;

import Business.Address.Address;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ContactTracingOrganization;
import UI.HospitalPanel;
import Business.Organization.CovidCareCenter;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.Organization.VaccineSiteOrganization;
import Business.Organization.VaccineSupplierOrganization;
import Business.Organization.VolunteerContactTracingOrganization;
import JxMaps.main.MapMarker;
import JxMaps.main.Modal.LatLong;
import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Skanda
 */
public class ManageOrganizationPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageOrganizationPanel
     */
    EcoSystem system;

    public ManageOrganizationPanel(EcoSystem system) {
        this.system = system;
        initComponents();
        networkBox.removeAllItems();
        for (String s : system.getNetworkMap().keySet()) {
            networkBox.addItem(s);
        }
        populateTable();
        populateOrgBox();
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
        entBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        orgBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        networkBox = new javax.swing.JComboBox<>();
        txtOrgName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orgTable = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Organizations");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Select Enterprise:");

        entBox.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        entBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Covid Care", "Vaccination Unit", "Contact Tracing", "Covid Analytics" }));
        entBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Select Organization Type:");

        orgBox.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        orgBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgBoxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Select Network");

        networkBox.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Organization Name");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-create-24.png"))); // NOI18N
        jButton1.setText("Add Organization");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Maps");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        orgTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Organization Name", "Network", "Location"
            }
        ));
        jScrollPane1.setViewportView(orgTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOrgName)
                            .addComponent(networkBox, 0, 140, Short.MAX_VALUE)
                            .addComponent(entBox, 0, 140, Short.MAX_VALUE)
                            .addComponent(orgBox, 0, 140, Short.MAX_VALUE))))
                .addContainerGap(394, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {entBox, networkBox, orgBox, txtOrgName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(networkBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(entBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orgBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtOrgName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {entBox, networkBox, orgBox, txtOrgName});

    }// </editor-fold>//GEN-END:initComponents

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) orgTable.getModel();
        model.setRowCount(0);
        for (Network n: system.getNetworkMap().values()) {
            for(Organization s:n.getCovidCare().getOrganizationDirectory().getOrgList()){
                model.addRow(new Object[]{s.getName(),n.getName(),s.getLocation()});  
            }  
            for(Organization s:n.getContactTracing().getOrganizationDirectory().getOrgList()){
                model.addRow(new Object[]{s.getName(),n.getName(),s.getLocation()});  
            }  
            for(Organization s:n.getVaxCenter().getOrganizationDirectory().getOrgList()){
                model.addRow(new Object[]{s.getName(),n.getName(),s.getLocation()});  
            } 
            for(Organization s:n.getAnalyticCenter().getOrganizationDirectory().getOrgList()){
                model.addRow(new Object[]{s.getName(),n.getName(),s.getLocation()});  
            }
        }
    }
    public void populateOrgBox(){
        orgBox.removeAll();
         if (!entBox.getSelectedItem().toString().equals("")) {
            String enter = entBox.getSelectedItem().toString();
            if (enter.equalsIgnoreCase("Covid Care")) {
                orgBox.removeAll();
                orgBox.addItem("Covid Care Center");
                orgBox.addItem("Pharmacy");
            } else if (enter.equalsIgnoreCase("Contact Tracing")) {
                orgBox.removeAll();
                orgBox.addItem("State Contact Tracing");
                orgBox.addItem("Volunteer Contact Tracing");
            } else if (enter.equalsIgnoreCase("Vaccination Unit")) {
                orgBox.removeAll();
                orgBox.addItem("Vaccination Site");
                orgBox.addItem("Vaccine Supplier");
            }
        }
    }
    private void entBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entBoxActionPerformed
        // TODO add your handling code here:
        orgBox.removeAllItems();
        populateOrgBox();

       
    }//GEN-LAST:event_entBoxActionPerformed

    private void orgBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!orgBox.getSelectedItem().toString().equals("")) {
            LatLong location = system.getTempLocation();
            location.setName(txtOrgName.getText());
            if(location == null){
                JOptionPane.showMessageDialog(this, "Please set a location", "Create fail", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            System.out.println("MY location"+location.toString());
            Network net = system.getNetworkMap().get(networkBox.getSelectedItem().toString());
            String org = orgBox.getSelectedItem().toString();
            if (org.equalsIgnoreCase("Covid Care Center")) {
                CovidCareCenter hosp = new CovidCareCenter(txtOrgName.getText());
                hosp.setLocation(location);
                net.getCovidCare().getHospitals().add(hosp);
                net.getCovidCare().getOrganizationDirectory().getOrgList().add(hosp);
            } else if (org.equalsIgnoreCase("Pharmacy")) {
                PharmacyOrganization pharm = new PharmacyOrganization(txtOrgName.getText());
                pharm.setLocation(location);
                net.getCovidCare().getPharmacies().add(pharm);        
                net.getCovidCare().getOrganizationDirectory().getOrgList().add(pharm);
            } else if (org.equals("State Contact Tracing")) {
                ContactTracingOrganization traceOrg = new ContactTracingOrganization(txtOrgName.getText());
                traceOrg.setLocation(location);
                net.getContactTracing().getContactOrg().add(traceOrg);
                net.getContactTracing().getOrganizationDirectory().getOrgList().add(traceOrg);
            } else if (org.equals("Volunteer Contact Tracing")) {
                VolunteerContactTracingOrganization volOrg = new VolunteerContactTracingOrganization(txtOrgName.getText());
                volOrg.setLocation(location);
                net.getContactTracing().getVolunteerOrg().add(volOrg);
                net.getContactTracing().getOrganizationDirectory().getOrgList().add(volOrg);
            } else if (org.equals("Vaccination Site")) {
                VaccineSiteOrganization volOrg = new VaccineSiteOrganization(txtOrgName.getText());
                volOrg.setLocation(location);
                net.getVaxCenter().getVaxSites().add(volOrg);
                net.getVaxCenter().getOrganizationDirectory().getOrgList().add(volOrg);
            } else if (org.equals("Vaccine Supplier")) {
                VaccineSupplierOrganization volOrg = new VaccineSupplierOrganization(txtOrgName.getText());
                volOrg.setLocation(location);
                net.getVaxCenter().getSuppliers().add(volOrg);
                net.getVaxCenter().getOrganizationDirectory().getOrgList().add(volOrg);
            }
            populateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a organization Type to add", "Create fail", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MapMarker map = new MapMarker();
        map.saveMapMarker(system);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> entBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> networkBox;
    private javax.swing.JComboBox<String> orgBox;
    private javax.swing.JTable orgTable;
    private javax.swing.JTextField txtOrgName;
    // End of variables declaration//GEN-END:variables
}
