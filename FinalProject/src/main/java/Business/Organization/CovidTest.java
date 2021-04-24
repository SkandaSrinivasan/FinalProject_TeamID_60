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
public class CovidTest {
    Patient testingPatient;
    Doctor referringDoctor;
    CovidCareCenter referringHospital;
    String outcome;
    Date orderedDate;
    String type;
    public enum TestOutcome{
        Positive("Positive"),
        Negative("Negative");
        private String value;
        private TestOutcome(String value){
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
    public CovidTest(Patient pat,Doctor doc,CovidCareCenter hosp){
        this.testingPatient = pat;
        this.referringDoctor = doc;
        this.referringHospital = hosp;
    }

    public Patient getTestingPatient() {
        return testingPatient;
    }

    public void setTestingPatient(Patient testingPatient) {
        this.testingPatient = testingPatient;
    }

    public Doctor getReferringDoctor() {
        return referringDoctor;
    }

    public void setReferringDoctor(Doctor referringDoctor) {
        this.referringDoctor = referringDoctor;
    }

    public CovidCareCenter getReferringHospital() {
        return referringHospital;
    }

    public void setReferringHospital(CovidCareCenter referringHospital) {
        this.referringHospital = referringHospital;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
