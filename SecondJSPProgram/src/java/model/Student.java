/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Student {

    private int id;
    private String name;
    private String email;
    private String dob;
    private double fee;

    public Student() {
    }

    public Student(int id, String name, String email, String dob, double fee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.fee = fee;
    }

    public Student(String name, String email, String dob, double fee) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.fee = fee;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

}
