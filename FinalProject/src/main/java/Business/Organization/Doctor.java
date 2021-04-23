/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Employee;
import Business.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulbi
 */
public class Doctor extends Employee{
    CovidCareCenter careCenter;
    List<Patient> patientList;
    String fullName;
    UserAccount user;
    
    public Doctor(){
        this.patientList = new ArrayList<>();
        
    }
    public CovidCareCenter getCareCenter() {
        return careCenter;
    }

    public void setCareCenter(CovidCareCenter careCenter) {
        this.careCenter = careCenter;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
    
     @Override
    public String toString() {
        return this.fullName;
    }
}
