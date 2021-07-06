package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "idrole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idrole;

    @Column(name = "rolestatus")
    private String rolestatus;

    @Column(name = "rolename")
    private String rolename;

    public Role() {
    }

    public Role(int idrole) {
        this.idrole = idrole;
    }

    public Role(String rolestatus, String rolename) {
        this.rolestatus = rolestatus;
        this.rolename = rolename;
    }

    public Role(int idrole, String rolestatus, String rolename) {
        this.idrole = idrole;
        this.rolestatus = rolestatus;
        this.rolename = rolename;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(String rolestatus) {
        this.rolestatus = rolestatus;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
