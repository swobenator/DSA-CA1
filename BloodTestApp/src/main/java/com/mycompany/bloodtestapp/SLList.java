/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

//NOTE:  we count elements from position 1. First node from the list is on position 1.
public class SLList implements LinearListInterface {

    private Node head;
    private int iSize;
    private Node curNode;
    private Node prevNode;

    public SLList() {
        head = null;
        iSize = 0;
        curNode = null;
        prevNode = null;
    }

    @Override
    public boolean isEmpty() {
        if (iSize == 0) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int size() {
        return iSize;
    }

    // assume the index is in the correct range
    @Override
    public void add(int iIndex, Object theElement) {
        // special case of adding at the head of the list ( on the first position)
        if (iIndex == 1) {
            Node newNode = new Node(theElement, head);
            head = newNode;
        } else {
            setCurrent(iIndex);
            Node newNode = new Node(theElement, curNode);
            prevNode.setNext(newNode);
        }
        // as a new one was added the size counter must be increased by 1
        iSize = iSize + 1;
    }

    //add an elemenst at the end of the list (on the last position)
    @Override
    public void add(Object theElement) {
        Node newNode = new Node(theElement, null);
        if (head == null) {
            head = newNode;
        } else {
            setCurrent(iSize);
            curNode.setNext(newNode);
        }
        iSize = iSize + 1;
    }

    @Override
    public Object get(int iIndex) {
        setCurrent(iIndex);
        return curNode;
    }

    @Override
    public void remove(int iIndex) {
        // special case for removing the head of the list / first node.
        if (iIndex == 1) {
            head = head.getNext();
        } else {
            // find the previous and current nodes
            setCurrent(iIndex);
            prevNode.setNext(curNode.getNext());
        }
        // as one node was removed the size counter must be decreased by 1
        iSize = iSize - 1;
    }

    private void setCurrent(int iIndex) {
        // sets curNode to the node at position specified by index
        // sets prevNode to the node previous to curNode
        int iCount;
        prevNode = null;
        curNode = head;
        for (iCount = 1; iCount < iIndex; iCount++) {
            prevNode = curNode;
            curNode = curNode.getNext();
        }
    }
                   
    @Override
    public String listNoShows() {
        StringBuffer result = new StringBuffer();  // Use StringBuffer instead of StringBuilder
        Node currentNode = head;  // Assuming `head` is the first node in the list
        result.append("NO SHOW LIST:");
        while (currentNode != null) {
            Patient patient = (Patient) currentNode.getElement();  // Get the patient from the node
            result.append("\nName: ").append(patient.getName()); 
            result.append("\nAge: ").append(patient.getAge());
            result.append("\n");  
            currentNode = currentNode.getNext();  //moveto the next node in the list
        }

        return result.toString();  //return the final result string 
    }
}
