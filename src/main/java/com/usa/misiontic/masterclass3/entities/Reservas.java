package com.usa.misiontic.masterclass3.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "reservas")
public class Reservas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;



    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "Id")
    @JsonIgnoreProperties("Id")
    private List<Reservas> libs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reservas> getLibs() {
        return libs;
    }

    public void setLibs(List<Reservas> libs) {
        this.libs = libs;
    }
}