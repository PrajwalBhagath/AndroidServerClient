/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Brock
 */
public class Scooter {
  
    private int id;
    private double latitude;
    private double longitude;
    private boolean available;

    public Scooter() {
    }

    public Scooter(int id, double latitude, double longitude, boolean available) {
        setId(id);
        setLatitude(latitude);
        setLongitude(longitude);
        setAvailable(available);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
     
    public String getJsonString(){
        StringBuilder buffer = new StringBuilder();
        
        buffer.append("{");
        
        buffer.append("\"id\":").append(getId()).append(",");
        buffer.append("\"lat\":").append(getLatitude()).append(",");
        buffer.append("\"long\":").append(getLongitude()).append(",");
        buffer.append("\"isAvailable\":").append(isAvailable());

        buffer.append("}");
        
        return buffer.toString();
    }
}
