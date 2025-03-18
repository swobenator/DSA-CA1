 
package com.mycompany.bloodtestapp;

import java.util.*;

public class MyPriorityQueue implements PQInterface {

    private ArrayList<PQElement> thePQueue;

    public MyPriorityQueue() {
        thePQueue = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return thePQueue.isEmpty();
    }

    @Override
    public int size() {
        return thePQueue.size();
    }

    @Override
    public void enqueue(String priority, Object thePatient) {
        int iIndex;
        PQElement newElement = new PQElement(priority, (Patient) thePatient);

        iIndex = findInsertPosition(newElement);

        if (iIndex == size()) {
            thePQueue.add(newElement);
        } else {
            thePQueue.add(iIndex, newElement);
        }
    }

    private int findInsertPosition(PQElement newElement) {
        boolean bFound = false;
        int iPosition = 0;
        PQElement curElement;
        Patient newPatient = (Patient) newElement.getPatient();

        //prioritize patients who are from the hospital ward
        while (iPosition < thePQueue.size() && !bFound) {
            curElement = thePQueue.get(iPosition);
            Patient curPatient = (Patient) curElement.getPatient();

            //hospital ward patients are always prioritized
            if (curPatient.isFromHospitalWard() && !newPatient.isFromHospitalWard()) {
                iPosition++;
            } else if (!curPatient.isFromHospitalWard() && newPatient.isFromHospitalWard()) {
                bFound = true;
            } else {
                // ifboth are from or not from hospital ward, check priority and age
                int priorityComparison = comparePriority(curElement, newElement);

                if (priorityComparison == 0) {
                    // if priorities are the same, compare by age
                    if (newPatient.getAge() < curPatient.getAge()) {
                        bFound = true;
                    } else {
                        iPosition++;
                    }
                } else if (priorityComparison < 0) {
                    iPosition++;
                } else {
                    bFound = true;
                }
            }
        }

        return iPosition;
    }

    //method to compare priotities
    private int comparePriority(PQElement curElement, PQElement newElement) {
        String curPriority = curElement.getPriority();
        String newPriority = newElement.getPriority();

        //priority comparison
        if (curPriority.equalsIgnoreCase("urgent") && !newPriority.equalsIgnoreCase("urgent")) {
            return -1;
        } else if (curPriority.equalsIgnoreCase("medium") && newPriority.equalsIgnoreCase("low")) {
            return -1;
        } else if (curPriority.equalsIgnoreCase("low") && !newPriority.equalsIgnoreCase("low")) {
            return 1;
        } else if (newPriority.equalsIgnoreCase("urgent") && !curPriority.equalsIgnoreCase("urgent")) {
            return 1;
        } else if (newPriority.equalsIgnoreCase("medium") && curPriority.equalsIgnoreCase("low")) {
            return 1;
        } else if (newPriority.equalsIgnoreCase("medium") && curPriority.equalsIgnoreCase("urgent")) {
            return -1;
        } else {
            return 0; //equal priority
        }
    }

    //remove the highest priority patient from the queue
    @Override
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }

        //remove  the first element (highest priority patient)
        return thePQueue.remove(0);
    }
    
    @Override
    public Object getElement(int i){
        return thePQueue.get(i);
    }

    @Override
    public String printPQueue() {
        StringBuilder printString = new StringBuilder();
        PQElement curElement;
        for (int iCount = 0; iCount < thePQueue.size(); iCount++) {
            curElement = thePQueue.get(iCount);
            printString.append(curElement.printPatient()).append("\nPriority: ").append(curElement.getPriority()).append("\n****");
        }
        return printString.toString();
    }
}
