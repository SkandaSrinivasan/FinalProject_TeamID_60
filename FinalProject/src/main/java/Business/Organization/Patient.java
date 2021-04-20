/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Person;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class Patient extends Person {
    String patientId;
    String insuranceNumber;
    UserAccount user;
    List<CovidTest> tests;

    public Patient(String name) {
        super(name);
        this.tests = new ArrayList<>();
    }
    
    
}
