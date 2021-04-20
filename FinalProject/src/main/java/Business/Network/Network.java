/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;

/**
 *
 * @author Skanda
 */
public class Network {
    EnterpriseDirectory enterpriseDir;
    String name;
    
    public Network(String name){
        this.enterpriseDir = new EnterpriseDirectory();
        this.name = name;
    }
}
