/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Address.Address;
import Business.Components.Prescription;
import Business.UserAccount.UserAccount;
import Role.HospitalAdminRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CovidCareCenter extends Organization{
    
    List<Doctor> doctorList;
    List<Patient> patientList;
    List<CovidTest> covidTests;
    List<Prescription> prescriptions;
    UserAccount admin;
    public CovidCareCenter(String name){
        super(name);
        this.role = new HospitalAdminRole();
        this.type = Organization.Type.CovidCareCenter;
        this.doctorList = new ArrayList<>();
        this.patientList = new ArrayList<>();
        this.covidTests = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public UserAccount getAdmin() {
        return admin;
    }

    public void setAdmin(UserAccount admin) {
        this.admin = admin;
    }

    public List<CovidTest> getCovidTests() {
        return covidTests;
    }

    public void setCovidTests(List<CovidTest> covidTests) {
        this.covidTests = covidTests;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }


    
}
