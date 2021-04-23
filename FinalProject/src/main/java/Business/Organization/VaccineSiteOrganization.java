/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Role.VaccineSiteAdminRole;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class VaccineSiteOrganization extends Organization {
    List<VaccineAppointment> vaccineApts;
    HashMap<String,Integer> vaccineStock = new HashMap<>();
    List<Patient> patients;
    int patientsVaxed;
    public VaccineSiteOrganization(String name){
        super(name);
        vaccineApts = new ArrayList<>();
        vaccineStock.put("Pfizer", 100);
        vaccineStock.put("Moderna", 100);
        vaccineStock.put("J&J", 100);
        this.patients = new ArrayList<>();
        this.role = new VaccineSiteAdminRole();
        this.type = Organization.Type.VaccineSite;
        patientsVaxed = 0;
    }

    public List<VaccineAppointment> getVaccineApts() {
        return vaccineApts;
    }

    public void setVaccineApts(List<VaccineAppointment> vaccineApts) {
        this.vaccineApts = vaccineApts;
    }

    public HashMap<String, Integer> getVaccineStock() {
        return vaccineStock;
    }

    public void setVaccineStock(HashMap<String, Integer> vaccineStock) {
        this.vaccineStock = vaccineStock;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public int getPatientsVaxed() {
        return patientsVaxed;
    }

    public void setPatientsVaxed(int patientsVaxed) {
        this.patientsVaxed = patientsVaxed;
    }
    
}
