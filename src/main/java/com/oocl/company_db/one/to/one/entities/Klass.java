package com.oocl.company_db.one.to.one.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "oocl_klass")
@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "klass", fetch = FetchType.LAZY)
//    @JoinColumn(name = "leader_id")
    private Leader leader;

    public Klass() {
    }

    public Klass(String name, long id) {
        this.name = name;
        this.id =id;
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

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }


}
