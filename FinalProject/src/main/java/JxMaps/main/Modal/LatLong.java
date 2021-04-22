/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JxMaps.main.Modal;

/**
 *
 * @author Skanda
 */
public class LatLong {
    private String latitude;
    private String longitude;
    private String name;
    
    public LatLong(String name, String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLong(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
        return "LatLong{" + "latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + '}';
    }


    
    
}
