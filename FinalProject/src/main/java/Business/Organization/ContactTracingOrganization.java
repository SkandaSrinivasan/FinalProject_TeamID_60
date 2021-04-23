/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Role.StateContactTracer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulbi
 */
public class ContactTracingOrganization extends Organization {
    
    List<Patient> patients;
    public ContactTracingOrganization(String name) {
        super(name);
        this.role = new StateContactTracer();
        this.patients = new ArrayList<>();
    }
}
