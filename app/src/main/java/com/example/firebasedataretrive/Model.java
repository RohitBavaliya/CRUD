package com.example.firebasedataretrive;

public class Model {
    String name, course, purl, email;
    Model()
    {

    }

    public Model(String name, String course, String purl, String email) {
        this.name = name;
        this.course = course;
        this.purl = purl;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
