/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person;
import Business.UserAccount.UserAccount;
import Role.PatientRole;
import Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class Patient extends Person {
    static int id = 1;
    String insuranceNumber;
    UserAccount user;
    List<CovidTest> tests;
    int patientId;
    Role role;

    public Patient(String name) {
        super(name);
        this.tests = new ArrayList<>();
        this.patientId = id;
        id+=1;
        this.role = new PatientRole();
    }
    
    
}
