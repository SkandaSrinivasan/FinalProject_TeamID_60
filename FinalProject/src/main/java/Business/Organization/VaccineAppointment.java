/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.Date;

/**
 *
 * @author Skanda
 */
public class VaccineAppointment {

    Date apptmtDate;
    VaccineSiteOrganization site;
    Patient patientProfile;
    String firstDose;
    String secondDose;
    public enum VaccineType{
        Pfizer("Pfizer"),
        Moderna("Moderna"),
        JJ("Johnson and Johnson");
        private String value;
        private VaccineType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
    public VaccineAppointment(){
        
    }

}
