/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bloodtestapp;

import java.util.ArrayList;

/**
 *
 * @author sohei
 */
public class myArrayList implements LinearListInterface{
    private ArrayList<Object> list = new ArrayList<>();
    
     @Override
    public void add(int index, Object patient) {
    }
    
    
    @Override
    public int size() {
        return list.size();
    }
    
    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public void add(Object patient) {
        list.add(patient);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }
    
    //list all stored patient details in a string 
    public String listElements() {
        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            return "No patient history available.\n";
        }
        //for each object(Patient) in the arraylist their details are added to the stringBuffer
        for (Object obj : list) {
            if (obj instanceof Patient) {
                Patient p = (Patient) obj;
                sb.append("Name: ").append(p.getName()).append("\n");
                sb.append("Age: ").append(p.getAge()).append("\n");
                sb.append("GP Details: ").append(p.getGp()).append("\n");
                sb.append("From Hospital Ward: ").append(p.isFromHospitalWard()).append("\n");
                sb.append("-------------------------------\n");
            }
        }
        //the final stringBuffer is cinverted into a String and returned
        return sb.toString();
    }
  
}
