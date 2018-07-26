package com.oocl.company_db.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Table(name = "oocl_company")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    private ZonedDateTime createDate = ZonedDateTime.now();

    public Company(String name,long id) {
        this.name = name;
        this.id =id;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
