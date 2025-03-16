package com.mycompany.bloodtestapp;

public class Patient {

    private String name;
    private String gp;
    private int age;
    private boolean fromHospitalWard;  

    public Patient() {
        this.name = new String();
        this.gp = new String();
        this.age = 0;
        this.fromHospitalWard = false; 
    }

    public void setFromHospitalWard(boolean fromHospitalWard) {
        this.fromHospitalWard = fromHospitalWard;
    }

    public boolean isFromHospitalWard() {
        return this.fromHospitalWard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGp() {
        return gp;
    }
}
