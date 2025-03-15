/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

import java.util.*;

/**
 *
 * @author Hamilton1
 */
public class MyPriorityQueue implements PQInterface {

    private ArrayList<PQElement> thePQueue;

    public MyPriorityQueue() {
        thePQueue = new ArrayList<PQElement>();
    }
    
    @Override
    public boolean isEmpty() {
        return thePQueue.isEmpty();
    }
    
    @Override
    public int size() {
        return thePQueue.size();
    }

    //a new element with a given key and element information will be added 
    @Override
    public void enqueue(String priority, Object thePatient) {
        int iIndex;
        PQElement newElement = new PQElement(priority, (Patient) thePatient);

        iIndex = findInsertPosition(priority);

        if (iIndex == size()) {
            thePQueue.add(newElement);
        } else {
            thePQueue.add(iIndex, newElement);
        }
    }

    //find the position where the new element will be added to the list in descending order
    //based on the key (priority) provided
    private int findInsertPosition(String priority) {
        boolean bFound = false;
        int iPosition = 0;
        PQElement curElement;
        while (iPosition < thePQueue.size() && !bFound) {
            curElement = thePQueue.get(iPosition);
            if (curElement.getPriority().equalsIgnoreCase(priority) ) {
                iPosition = iPosition + 1;
            } else {
                bFound = true;
            }
        }
        return iPosition;
    }

    //remove the first element on the list, which has the highest key (priority)
    @Override
    public Object dequeue() {
        return thePQueue.remove(0);
    }

    @Override
    public String printPQueue() {
        String printString = new String();
        PQElement curElement;
        for (int iCount = 0; iCount < thePQueue.size(); iCount++) {
            curElement = thePQueue.get(iCount);
            printString = printString.concat(curElement.printPatient() + "\nPriority: " + curElement.getPriority() + "\n****");
        }
        return printString;
    }
}
