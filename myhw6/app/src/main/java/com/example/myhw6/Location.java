package com.example.myhw6;

public class Location {
//    private string name;
    double Longitude;
    double Latitude;
//    String description;
//    String image;

    public Location (double longitude, double latitude){
        this.Longitude = longitude;
        this.Latitude = latitude;

    }

    public void setLongitude(double longitude) { this.Longitude = longitude;}

    public void setLatitude(double latitude) { this.Latitude = latitude;}

    public  String toString(){
        String str = "Longitude: " + Longitude + ", Latitude: " + Latitude;
        return str;
    }
}
