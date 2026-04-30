package com.example.projectam.models;

import java.io.Serializable;
import java.util.List;

public class Faculty implements Serializable {
    private int id;
    private String nameKey;
    private String nameAr;
    private String description;
    private String descriptionAr;
    private String dean;
    private String phone;
    private String email;
    private double latitude;
    private double longitude;
    private String campus;
    private String logoResourceName;
    private List<Department> departments;

    public Faculty(int id, String nameKey, String nameAr, String description,
                   String descriptionAr, String dean, String phone,
                   String email, double latitude, double longitude, String campus, String logoResourceName) {
        this.id = id;
        this.nameKey = nameKey;
        this.nameAr = nameAr;
        this.description = description;
        this.descriptionAr = descriptionAr;
        this.dean = dean;
        this.phone = phone;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
        this.campus = campus;
        this.logoResourceName = logoResourceName;
    }

    public int getId() { return id; }
    public String getNameKey() { return nameKey; }
    public String getNameAr() { return nameAr; }
    public String getDescription() { return description; }
    public String getDescriptionAr() { return descriptionAr; }
    public String getDean() { return dean; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getCampus() { return campus; }
    public String getLogoResourceName() { return logoResourceName; }
    public List<Department> getDepartments() { return departments; }
    public void setDepartments(List<Department> departments) { this.departments = departments; }
}