/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Patient;

import Business.Components.Prescription;
import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.CovidTest;
import Business.Organization.Patient;
import Business.UserAccount.UserAccount;
import javax.swing.table.DefaultTableModel;

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
        this.ua = ua;
        pat= null;
        for (Network net : system.getNetworkMap().values()) {
            for (Patient p : net.getPatientDirectory().getPatients()) {
                if (p.getUser().equals(ua)) {
                    pat = p;
                }
            }
        }
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)cTable.getModel();
       model.setRowCount(0);
       for(CovidTest c:pat.getTests()){
           model.addRow(new Object[]{c.getOrderedDate(),c.getType(),c.getOutcome(),c.getReferringHospital().getName()});
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
        cTable = new javax.swing.JTable();

        jLabel1.setBackground(new java.awt.Color(0, 184, 148));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Covid Tests");
        jLabel1.setOpaque(true);

        cTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ordered Date", "Test Type", "Result", "Hospital Taken At"
            }
        ));
        jScrollPane1.setViewportView(cTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
