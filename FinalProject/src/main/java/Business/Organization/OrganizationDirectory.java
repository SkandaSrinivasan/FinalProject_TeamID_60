/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.List;

/**
 *
 * @author Skanda
 */
public class OrganizationDirectory {
    List<Organization> orgList;

    public List<Organization> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<Organization> orgList) {
        this.orgList = orgList;
    }
    
    public Organization getOrganization(String name){
        for(Organization org:this.orgList){
            if(org.getName().equals(name)){
                return org;
            }
        }
        return null;
    }
}
