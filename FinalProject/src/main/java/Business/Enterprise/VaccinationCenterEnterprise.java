/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Organization.VaccineSiteOrganization;
import Business.Organization.VaccineSupplierOrganization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class VaccinationCenterEnterprise extends Enterprise {
    List<VaccineSiteOrganization> vaxSites;
    List<VaccineSupplierOrganization> suppliers;
    public VaccinationCenterEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.VaccinationUnit);
        this.vaxSites = new ArrayList<>();
        this.suppliers = new ArrayList<>();
        this.setOrganizationDirectory(new OrganizationDirectory());
    }

    public List<VaccineSiteOrganization> getVaxSites() {
        return vaxSites;
    }

    public void setVaxSites(List<VaccineSiteOrganization> vaxSites) {
        this.vaxSites = vaxSites;
    }

    public List<VaccineSupplierOrganization> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<VaccineSupplierOrganization> suppliers) {
        this.suppliers = suppliers;
    }
    
}
