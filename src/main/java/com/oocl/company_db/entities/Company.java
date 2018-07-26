package com.oocl.company_db.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Table(name = "oocl_company")
@Entity
public class Company {
    @Id
    @GeneratedValue
    private  long id;
    private  String name;
    @CreatedDate
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

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }
}
