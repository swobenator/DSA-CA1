/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

/**
 *
 * @author Hamilton1
 */
public class Patient {

    private String name;
    private String gp;

    public Patient() {
        this.name = new String();
        this.gp = new String();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getName() {
        return name;
    }

    public String getGp() {
        return gp;
    }
}
