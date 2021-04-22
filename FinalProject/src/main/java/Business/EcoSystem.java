/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import JxMaps.main.Modal.LatLong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Skanda
 */
public class EcoSystem {

    private static EcoSystem business;
    private Map<String, Network> networkMap;
    UserAccountDirectory userDir;
    LatLong tempLocation;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    Random rand;

    EcoSystem() {
        this.networkMap = new HashMap<>();
        userDir = new UserAccountDirectory();
        this.rand = new Random();
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public UserAccountDirectory getUserDir() {
        return userDir;
    }

    public void setUserDir(UserAccountDirectory userDir) {
        this.userDir = userDir;
    }

    public Map<String, Network> getNetworkMap() {
        return networkMap;
    }

    public void setNetworkMap(Map<String, Network> networkMap) {
        this.networkMap = networkMap;
    }

    public LatLong getTempLocation() {
        return tempLocation;
    }

    public void setTempLocation(LatLong tempLocation) {
        this.tempLocation = tempLocation;
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

}
