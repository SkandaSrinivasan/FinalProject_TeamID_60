/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Address.Address;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CovidCareCenter extends Organization{
    String name;
    Address address;
    List<Patient> patientList;
    public CovidCareCenter(String name){
        super(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
