/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Components.PatientDirectory;
import Business.Enterprise.ContactTracingEnterprise;
import Business.Enterprise.CovidAnalyticsEnterprise;
import Business.Enterprise.CovidCareEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.VaccinationCenterEnterprise;
import Business.Organization.Organization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class Network {
    CovidCareEnterprise covidCare;
    ContactTracingEnterprise contactTracing;
    VaccinationCenterEnterprise vaxCenter;
    CovidAnalyticsEnterprise analyticCenter;
    List<Enterprise> enterpriseList;
    PatientDirectory patientDirectory;
    String name;
    
    public Network(String name){
        this.name = name;
        this.covidCare = new CovidCareEnterprise("Covid Care Enterprise");
        this.contactTracing = new ContactTracingEnterprise("Contact Tracing Enterprise");
        this.vaxCenter = new VaccinationCenterEnterprise("Vaccination Center Enterprise");
        this.analyticCenter = new CovidAnalyticsEnterprise("Covid Analytics Enterprise");       
        this.enterpriseList = new ArrayList<>();
        enterpriseList.add(covidCare);
        enterpriseList.add(vaxCenter);
        enterpriseList.add(analyticCenter);
        enterpriseList.add(contactTracing);
        this.patientDirectory = new PatientDirectory();
        
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CovidCareEnterprise getCovidCare() {
        return covidCare;
    }

    public void setCovidCare(CovidCareEnterprise covidCare) {
        this.covidCare = covidCare;
    }

    public ContactTracingEnterprise getContactTracing() {
        return contactTracing;
    }

    public void setContactTracing(ContactTracingEnterprise contactTracing) {
        this.contactTracing = contactTracing;
    }

    public VaccinationCenterEnterprise getVaxCenter() {
        return vaxCenter;
    }

    public void setVaxCenter(VaccinationCenterEnterprise vaxCenter) {
        this.vaxCenter = vaxCenter;
    }

    public CovidAnalyticsEnterprise getAnalyticCenter() {
        return analyticCenter;
    }

    public void setAnalyticCenter(CovidAnalyticsEnterprise analyticCenter) {
        this.analyticCenter = analyticCenter;
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(List<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    @Override
    public String toString() {
        return this.name;
    }

    public PatientDirectory getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(PatientDirectory patientDirectory) {
        this.patientDirectory = patientDirectory;
    }
    
}
