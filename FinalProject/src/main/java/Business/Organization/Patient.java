/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Components.Prescription;
import Business.Person;
import Business.UserAccount.UserAccount;
import JxMaps.main.Modal.LatLong;
import Role.PatientRole;
import Role.Role;
import java.util.ArrayList;
import java.util.Date;
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
    List<Prescription> prescriptions;
    boolean activeAppointment;
    boolean vaxAppointment;
    Date appointmentDate;
    String appointmentStatus;
    public Patient(String name,double id) {
        super(name);
        this.tests = new ArrayList<>();
        this.id = id;
        this.role = new PatientRole();
        this.prescriptions = new ArrayList<>();
        this.activeAppointment = false;
        this.appointmentStatus = "No Current appointment";
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

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public boolean isActiveAppointment() {
        return activeAppointment;
    }

    public void setActiveAppointment(boolean activeAppointment) {
        this.activeAppointment = activeAppointment;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public boolean isVaxAppointment() {
        return vaxAppointment;
    }

    public void setVaxAppointment(boolean vaxAppointment) {
        this.vaxAppointment = vaxAppointment;
    }
    
    
}
