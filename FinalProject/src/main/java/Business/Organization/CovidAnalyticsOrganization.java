/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Role.CovidAnalyticsAdmin;

/**
 *
 * @author Skanda
 */
public class CovidAnalyticsOrganization extends Organization {
    
    public CovidAnalyticsOrganization(String name) {
        super(name);
        this.role = new CovidAnalyticsAdmin();
        this.type = Organization.Type.CovidAnalytics;
    }
    
}
