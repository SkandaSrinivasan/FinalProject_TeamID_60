/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Patient;

import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.CovidCareCenter;
import Business.Organization.Doctor;
import Business.Organization.Organization;
import Business.Organization.Patient;
import Business.UserAccount.UserAccount;
import JxMaps.main.MapMarker;
import JxMaps.main.Modal.LatLong;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Skanda
 */
public class CovidCareAppointment extends javax.swing.JPanel {

    /**
     * Creates new form AppointmentPanel
     */
    EcoSystem system;
    UserAccount user;

    public CovidCareAppointment(EcoSystem system,UserAccount ua) {
        initComponents();
        this.system = system;
        for (Network n : system.getNetworkMap().values()) {
            networkBox.addItem(n);
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
        networkBox = new javax.swing.JComboBox<>();
        btnSetLocation = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        docBox = new javax.swing.JComboBox<>();
        btnMakeAppointment = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Covid Care Appoinment Finder");

        jLabel2.setText("Select your Network:");

        btnSetLocation.setText("Select your Preferred CovidCare Center");
        btnSetLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetLocationActionPerformed(evt);
            }
        });

        jLabel3.setText("Select your doctor:");

        btnMakeAppointment.setText("Make Appointment");
        btnMakeAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMakeAppointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMakeAppointment)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(docBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(btnSetLocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(networkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(networkBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSetLocation)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(docBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMakeAppointment)
                .addGap(0, 313, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetLocationActionPerformed
        // TODO add your handling code here:
        Network net = (Network) networkBox.getSelectedItem();
        List<LatLong> coordinateList = new ArrayList<>();
        for (CovidCareCenter o : net.getCovidCare().getHospitals()) {
            coordinateList.add(o.getLocation());
        }
        MapMarker map = new MapMarker();
        map.setMapMarkers(coordinateList);
        
    }//GEN-LAST:event_btnSetLocationActionPerformed

    private void btnMakeAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMakeAppointmentActionPerformed
        // TODO add your handling code here:
        
        Network net = (Network) networkBox.getSelectedItem();
        Patient pat = null;
        for(Patient p:net.getPatientDirectory().getPatients()){
            if(p.getUser().equals(user)){
                pat = p;
            }
        }
        LatLong tempLoc = system.getTempLocation();
        if (tempLoc == null) {
            JOptionPane.showMessageDialog(this, "Please set a valid location", "Create fail", JOptionPane.INFORMATION_MESSAGE);

        } else {
            CovidCareCenter co = null;
            for (CovidCareCenter o : net.getCovidCare().getHospitals()) {
                if(o.getLocation().equals(system.getTempLocation())){
                    co = o;
                }
            }
            Doctor doc = (Doctor) docBox.getSelectedItem();
            pat.setActiveAppointment(true);
            co.getPatientList().add(pat);
            doc.getPatientList().add(pat);
            system.setTempLocation(null);
        }
    }//GEN-LAST:event_btnMakeAppointmentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMakeAppointment;
    private javax.swing.JButton btnSetLocation;
    private javax.swing.JComboBox<Doctor> docBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Network> networkBox;
    // End of variables declaration//GEN-END:variables
}