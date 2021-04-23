/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.CovidAnalyticsOrganization;
import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class CovidAnalyticsEnterprise extends Enterprise {
    List<CovidAnalyticsOrganization> analytics;
    public CovidAnalyticsEnterprise(String name) {
        super(name, Enterprise.EnterpriseType.AnalyticsUnit);
        this.setOrganizationDirectory(new OrganizationDirectory());
        this.analytics = new ArrayList<>();
    }

    public List<CovidAnalyticsOrganization> getAnalytics() {
        return analytics;
    }

    public void setAnalytics(List<CovidAnalyticsOrganization> analytics) {
        this.analytics = analytics;
    }
}
