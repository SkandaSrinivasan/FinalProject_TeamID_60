/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.List;

/**
 *
 * @author kulbi
 */
public class CovidTestingOrganization extends Organization{
    List<CovidTest> tests;
    String name;
    public CovidTestingOrganization(String name){
        super(name);
  
    }
    
}
