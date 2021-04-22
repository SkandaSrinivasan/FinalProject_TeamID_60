/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.ContactTracingOrganization;
import Business.Organization.VolunteerContactTracingOrganization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class ContactTracingEnterprise extends Enterprise {
    List<ContactTracingOrganization> contactOrg;
    List<VolunteerContactTracingOrganization> volunteerOrg;
    public ContactTracingEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.ContactTracingUnit);
        this.contactOrg = new ArrayList<>();
        this.volunteerOrg = new ArrayList<>();
    }

    public List<ContactTracingOrganization> getContactOrg() {
        return contactOrg;
    }

    public void setContactOrg(List<ContactTracingOrganization> contactOrg) {
        this.contactOrg = contactOrg;
    }

    public List<VolunteerContactTracingOrganization> getVolunteerOrg() {
        return volunteerOrg;
    }

    public void setVolunteerOrg(List<VolunteerContactTracingOrganization> volunteerOrg) {
        this.volunteerOrg = volunteerOrg;
    }
    
}
