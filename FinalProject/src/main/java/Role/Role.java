/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Skanda
 */
public abstract class Role {
    String name;
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        VaccineSiteAdmin("VaccineSiteAdmin");
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer,UserAccount account, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}