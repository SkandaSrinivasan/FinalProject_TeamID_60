/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Role;

import Business.EcoSystem;
import Business.UserAccount.UserAccount;
import UI.ContactTracing.ContactTracingPanel;
import javax.swing.JPanel;

/**
 *
 * @author Skanda
 */
public class StateContactTracer extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, EcoSystem business) {
        return new ContactTracingPanel(business,account);
    }
    
}
