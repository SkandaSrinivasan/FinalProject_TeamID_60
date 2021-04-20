/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

/**
 *
 * @author Skanda
 */
public class CovidTest {
    Patient testingPatient;
    Doctor referringDoctor;
    Hospital referringHospital;
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
    public CovidTest(Patient pat,Doctor doc,Hospital hosp){
        this.testingPatient = pat;
        this.referringDoctor = doc;
        this.referringHospital = hosp;
    }
}
