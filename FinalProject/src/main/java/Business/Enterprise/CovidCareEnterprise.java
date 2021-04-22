/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.CovidCareCenter;
import Business.Organization.PharmacyOrganization;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CovidCareEnterprise extends Enterprise{
    List<CovidCareCenter> hospitals;
    List<PharmacyOrganization> pharmacies;
    public CovidCareEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.CovidCareUnit);
        this.hospitals = new ArrayList<>();
        this.pharmacies = new ArrayList<>();
    }
    
}