/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import UI.Analytics.AnalyticsAdmin;
import javax.swing.JPanel;

/**
 *
 * @author Skanda
 */
public class CovidAnalyticsAdmin extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new AnalyticsAdmin(business); //To change body of generated methods, choose Tools | Templates.
    }
    
}
