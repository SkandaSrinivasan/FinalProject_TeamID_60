/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Components.Prescription;
import Role.PharmacyAdminRole;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class PharmacyOrganization extends Organization{
    List<Prescription> prescriptions;
    public PharmacyOrganization(String name) {
        super(name);
        this.prescriptions = new ArrayList<>();
        this.role = new PharmacyAdminRole();
        this.setType(Organization.Type.Pharmacy);
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
    
}
