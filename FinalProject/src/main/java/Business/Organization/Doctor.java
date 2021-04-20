/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Employee;
import Business.Person;
import Business.UserAccount.UserAccount;
import java.util.List;

/**
 *
 * @author kulbi
 */
public class Doctor extends Employee{
    CovidCareCentre careCenter;
    List<Patient> patientList;
    String fullName;
    UserAccount user;
    
}
