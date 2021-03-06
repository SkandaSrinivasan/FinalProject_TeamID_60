/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Components;

import Business.Organization.Doctor;
import Business.Organization.PharmacyOrganization;
import java.util.Date;

/**
 *
 * @author Skanda
 */
public class Prescription {
    Date prescribedDate;
    Doctor prescribingDoctor;
    String note;
    String filled;
    Date filledDate;
    PharmacyOrganization pharm;
    public Prescription(Date date,String note,Doctor doc,PharmacyOrganization pharm){
        this.prescribedDate = date;
        this.note = note;
        this.prescribingDoctor= doc;
        this.filled = "Unfilled";
        this.pharm = pharm;
    }

    public Date getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(Date prescribedDate) {
        this.prescribedDate = prescribedDate;
    }

    public Doctor getPrescribingDoctor() {
        return prescribingDoctor;
    }

    public void setPrescribingDoctor(Doctor prescribingDoctor) {
        this.prescribingDoctor = prescribingDoctor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
     @Override
    public String toString() {
        return prescribedDate.toString();

    }

    public String getFilled() {
        return filled;
    }

    public void setFilled(String filled) {
        this.filled = filled;
    }

    public Date getFilledDate() {
        return filledDate;
    }

    public void setFilledDate(Date filledDate) {
        this.filledDate = filledDate;
    }

    public PharmacyOrganization getPharm() {
        return pharm;
    }

    public void setPharm(PharmacyOrganization pharm) {
        this.pharm = pharm;
    }
    
}
