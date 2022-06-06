package com.example.javamapclient;

import com.google.android.gms.maps.model.LatLng;

public class LatLong {

    private int id;
    private double lat;
    private double lng;
    private boolean isAvailable;
    private LatLng coordinates;

    public LatLong(int id , double lat, double lng, boolean isAvailable, LatLng latLng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.isAvailable = isAvailable;
        this.coordinates = latLng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public LatLng getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }
}

