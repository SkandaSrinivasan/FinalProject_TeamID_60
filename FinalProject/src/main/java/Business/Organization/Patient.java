/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Components.Prescription;
import Business.Network.Network;
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
    double id = 0;
    String name;
    String insuranceNumber;
    UserAccount user;
    List<CovidTest> tests;
    String patientId;
    Role role;
    LatLong location;
    List<Prescription> prescriptions;
    boolean activeAppointment;
    boolean vaxAppointment;
    Date appointmentDate;
    String vaxStatus;
    String appointmentStatus;
    Network network;
    String covidStatus;
    String requestedVaccine;
    
    public Patient(String name, String id,Network network) {
        super(name);
        this.name = name;
        this.tests = new ArrayList<>();
        this.patientId = id;
        this.role = new PatientRole();
        this.prescriptions = new ArrayList<>();
        this.activeAppointment = false;
        this.appointmentStatus = "No Current appointment";
        this.network = network;
        this.covidStatus = "Negative";
        this.vaxStatus = "Unvaccinated";
    }

    public double getId() {
        return id;
    }
 @Override
    public String toString() {
        return getName();
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
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

   

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public String getVaxStatus() {
        return vaxStatus;
    }

    public void setVaxStatus(String vaxStatus) {
        this.vaxStatus = vaxStatus;
    }

    public String getRequestedVaccine() {
        return requestedVaccine;
    }

    public void setRequestedVaccine(String requestedVaccine) {
        this.requestedVaccine = requestedVaccine;
    }

}
