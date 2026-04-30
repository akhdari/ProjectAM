package com.example.projectam.models;

import java.io.Serializable;

public class Department implements Serializable {
    private int id;
    private int facultyId;
    private String nameKey;
    private String nameAr;
    private String description;
    private String descriptionAr;
    private String head;
    private String phone;
    private String email;
    private String specialties;

    public Department(int id, int facultyId, String nameKey, String nameAr,
                      String description, String descriptionAr, String head,
                      String phone, String email, String specialties) {
        this.id = id;
        this.facultyId = facultyId;
        this.nameKey = nameKey;
        this.nameAr = nameAr;
        this.description = description;
        this.descriptionAr = descriptionAr;
        this.head = head;
        this.phone = phone;
        this.email = email;
        this.specialties = specialties;
    }

    public int getId() { return id; }
    public int getFacultyId() { return facultyId; }
    public String getNameKey() { return nameKey; }
    public String getNameAr() { return nameAr; }
    public String getDescription() { return description; }
    public String getDescriptionAr() { return descriptionAr; }
    public String getHead() { return head; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getSpecialties() { return specialties; }
}