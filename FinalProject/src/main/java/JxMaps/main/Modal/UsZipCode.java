/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main.Modal;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author Skanda
 */
public class UsZipCode {
    
    @CsvBindByPosition(position = 0)
    private String zipCode;

    @CsvBindByPosition(position = 1)
    private String city;

    @CsvBindByPosition(position = 2)
    private String state;

    @CsvBindByPosition(position = 3)
    private String latitude;
    
    @CsvBindByPosition(position = 4)
    private String longitude;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UsZipCode{" + "zipCode=" + zipCode + ", city=" + city + ", state=" + state + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
    
}
