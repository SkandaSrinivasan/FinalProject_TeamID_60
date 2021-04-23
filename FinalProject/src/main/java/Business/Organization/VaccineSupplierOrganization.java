/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Components.VaccineSupplyRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kulbi
 */
public class VaccineSupplierOrganization extends Organization {
    int modernaDoses;
    int pfizerDoses;
    int jjDoses;
    List<VaccineSupplyRequest> requests;
    public VaccineSupplierOrganization(String name) {
        super(name);
        this.requests = new ArrayList<>();
        this.modernaDoses = 500;
        this.pfizerDoses = 500;
        this.jjDoses = 500;
        this.type = Organization.Type.VaccineSupplier;
    }

    public List<VaccineSupplyRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<VaccineSupplyRequest> requests) {
        this.requests = requests;
    }

    public int getModernaDoses() {
        return modernaDoses;
    }

    public void setModernaDoses(int modernaDoses) {
        this.modernaDoses = modernaDoses;
    }

    public int getPfizerDoses() {
        return pfizerDoses;
    }

    public void setPfizerDoses(int pfizerDoses) {
        this.pfizerDoses = pfizerDoses;
    }

    public int getJjDoses() {
        return jjDoses;
    }

    public void setJjDoses(int jjDoses) {
        this.jjDoses = jjDoses;
    }
    
}
