/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;


public interface PQInterface {

    public void enqueue(String priority, Object thePatient);

    public Object dequeue();

    public int size();
    
    public Object getElement(int i);

    public boolean isEmpty();

    public String printPQueue();
}
