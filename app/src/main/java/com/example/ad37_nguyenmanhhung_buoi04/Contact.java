package com.example.ad37_nguyenmanhhung_buoi04;

public class Contact {
    int call;
    String numberName;
    String country;
    String date;

    public Contact(int call, String numberName, String country, String date) {
        this.call = call;
        this.numberName = numberName;
        this.country = country;
        this.date = date;
    }

    public int getCall() {
        return call;
    }

    public void setCall(int call) {
        this.call = call;
    }

    public String getNumberName() {
        return numberName;
    }

    public void setNumberName(String numberName) {
        this.numberName = numberName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
