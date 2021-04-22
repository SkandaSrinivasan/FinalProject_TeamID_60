/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person;
import Business.UserAccount.UserAccount;
import JxMaps.main.Modal.LatLong;
import Role.PatientRole;
import Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class Patient extends Person {
    double id=0;
    String insuranceNumber;
    UserAccount user;
    List<CovidTest> tests;
    int patientId;
    Role role;
    LatLong location;

    public Patient(String name,double id) {
        super(name);
        this.tests = new ArrayList<>();
        this.id = id;
        this.role = new PatientRole();
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

 
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public List<CovidTest> getTests() {
        return tests;
    }

    public void setTests(List<CovidTest> tests) {
        this.tests = tests;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LatLong getLocation() {
        return location;
    }

    public void setLocation(LatLong location) {
        this.location = location;
    }
    
    
}
