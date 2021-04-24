/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Address;

import JxMaps.main.Modal.LatLong;

/**
 *
 * @author Skanda
 */
public class Address {

    String streetAddress;
    String zipcode;
    LatLong coords;

    public Address(String street, String zipcode) {
        this.streetAddress = street;
        this.zipcode = zipcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
