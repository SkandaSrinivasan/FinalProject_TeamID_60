/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.Date;

/**
 *
 * @author Skanda
 */
public class VaccinationRecord {
    enum Type {
        Pfizer,
        Moderna,
        JJ
    }
    Type vaccineType;
    Date firstDoseDate;
    Date secondDoseDate;

    public Date getFirstDoseDate() {
        return firstDoseDate;
    }

    public void setFirstDoseDate(Date firstDoseDate) {
        this.firstDoseDate = firstDoseDate;
    }

    public Date getSecondDoseDate() {
        return secondDoseDate;
    }

    public void setSecondDoseDate(Date secondDoseDate) {
        this.secondDoseDate = secondDoseDate;
    }
    
}
