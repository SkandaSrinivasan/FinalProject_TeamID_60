/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Coordinates.Coordinates;

/**
 *
 * @author Skanda
 */
public class Person {
    String name;
    String streetAddress;
    String zipcode;
    String homeNumber;
    Coordinates coords;
    
    public Person(String name){
        this.name = name;
    }
}
