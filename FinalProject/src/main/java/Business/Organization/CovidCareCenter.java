/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Address.Address;
import Business.UserAccount.UserAccount;
import Role.HospitalAdminRole;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CovidCareCenter extends Organization{

    List<Patient> patientList;
    UserAccount admin;
    public CovidCareCenter(String name){
        super(name);
        this.role = new HospitalAdminRole();
    }


    
}
