/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Skanda
 */
public class EcoSystem {

    private static EcoSystem business;
    private List<Network> networkList;
    UserAccountDirectory userDir;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    EcoSystem() {
        networkList = new ArrayList<Network>();
        userDir = new UserAccountDirectory();
    }

}
