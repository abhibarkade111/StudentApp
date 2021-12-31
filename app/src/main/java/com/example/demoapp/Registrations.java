package com.example.demoapp;

public class Registrations {
    private String name;
    private String email;
    private String stuclass;
    private String mob;
    private String branch;

    public Registrations(String name, String email, String stuclass, String mob, String branch) {
        this.name = name;
        this.email = email;
        this.stuclass = stuclass;
        this.mob = mob;
        this.branch = branch;
    }

    public Registrations() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
