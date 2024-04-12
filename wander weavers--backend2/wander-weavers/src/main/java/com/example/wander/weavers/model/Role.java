package com.example.wander.weavers.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String qualification;
    private String experience;

    public Role() {
    }

    public Role(Long id, String name,String qualification,String experience) {
        this.id = id;
        this.name = name;
        this.qualification=qualification;
        this.experience=experience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String qualification) {
        this.qualification = qualification;
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String name) {
        this.name = name;
    }
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

   
}
