package com.example.jerome.myfut;

import java.io.Serializable;
/**
 * Created by Jerome on 30/12/2014.
 */
public class Infos implements Serializable {
    private String name;
    private String surname;
    private String email;
    private String phoneNum;
    public Infos(String name, String surname, String email, String phoneNum) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNum = phoneNum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
