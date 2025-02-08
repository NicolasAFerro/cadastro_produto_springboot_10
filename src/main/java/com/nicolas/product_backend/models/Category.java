package com.nicolas.product_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CATEGORY")
public class Category {

    @Id
    private int id;
    private String name;

    public Category() {
    }


    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    } 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
