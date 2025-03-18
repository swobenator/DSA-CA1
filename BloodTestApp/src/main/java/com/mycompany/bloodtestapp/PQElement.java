
package com.mycompany.bloodtestapp;


public class PQElement {

    private String priority;
    private Patient patient;

    public PQElement(String priority, Patient patient) {
        this.priority = priority;
        this.patient = patient;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
     public boolean isFromHospitalWard() {
        return patient.isFromHospitalWard();  
    }

    public String printPatient() {
        String sMessage;
        sMessage = "****\nName: " + patient.getName() + "\nAge: " + patient.getAge() + "\nFrom Hospital Ward?: " + patient.isFromHospitalWard() 
                +  "\nGP Details: " + patient.getGp();
        return sMessage;
    }
}
