/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Components;

import Business.Organization.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class PatientDirectory {
    List<Patient> patients;
    
    public PatientDirectory(){
        this.patients = new ArrayList<>();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    public Patient getPatient(Double patientId){
        for(Patient p:this.patients){
            if(p.getId() == patientId){
                return p;
            }
        }
        return null;
    }
}
