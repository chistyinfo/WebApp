package com.example.developer.webapp;

public class Events {
    private String Date;
    private String Dv;
    private String Name;
    private String YE;
    private String RD;

    public Events() {
    }

    public Events(String date, String dv, String name, String YE, String RD) {
        Date = date;
        Dv = dv;
        Name = name;
        this.YE = YE;
        this.RD = RD;
    }

    public String getDate() {
        return Date;
    }

    public String getDv() {
        return Dv;
    }

    public String getName() {
        return Name;
    }

    public String getYE() {
        return YE;
    }

    public String getRD() {
        return RD;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDv(String dv) {
        Dv = dv;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setYE(String YE) {
        this.YE = YE;
    }

    public void setRD(String RD) {
        this.RD = RD;
    }
}
