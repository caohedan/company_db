package com.oocl.company_db.one.to.one.entities;

import javax.persistence.*;

@Table(name = "oocl_leader")
@Entity
public class Leader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "klass_id")
    private Klass klass;
    public Leader(String name, Klass klass) {
        this.name = name;
        this.klass = klass;
    }

    public Leader() {
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

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

}
