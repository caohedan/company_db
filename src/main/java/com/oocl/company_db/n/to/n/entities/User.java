package com.oocl.company_db.n.to.n.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
}
