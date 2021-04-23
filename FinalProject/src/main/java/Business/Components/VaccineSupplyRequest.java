/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Components;

import Business.Organization.VaccineSiteOrganization;

/**
 *
 * @author Skanda
 */
public class VaccineSupplyRequest {
    String requestedVaccine;
    String dosesRequired;
    VaccineSiteOrganization site;
    public VaccineSupplyRequest(String requestedVaccine,String dosesRequired,VaccineSiteOrganization site){
        this.requestedVaccine = requestedVaccine;
        this.dosesRequired = dosesRequired;
        this.site = site;
    }

    public String getRequestedVaccine() {
        return requestedVaccine;
    }

    public void setRequestedVaccine(String requestedVaccine) {
        this.requestedVaccine = requestedVaccine;
    }

    public String getDosesRequired() {
        return dosesRequired;
    }

    public void setDosesRequired(String dosesRequired) {
        this.dosesRequired = dosesRequired;
    }

    public VaccineSiteOrganization getSite() {
        return site;
    }

    public void setSite(VaccineSiteOrganization site) {
        this.site = site;
    }
    
}
