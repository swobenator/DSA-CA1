/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

/**
 *
 * @author Hamilton1
 */
public class PQElement {

    private String priority;
    private Patient patient;

    public PQElement(String priority, Patient inPatient) {
        this.priority = priority;
        this.patient = inPatient;
    }

    public String getPriority() {
        return priority;
    }

    public void setiKey(String priority) {
        this.priority = priority;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient inPatient) {
        this.patient = inPatient;
    }

    public String printPatient() {
        String sMessage;
        sMessage = "****\nName: " + patient.getName() + "\nGP Details: " + patient.getGp();
        return sMessage;
    }
}
