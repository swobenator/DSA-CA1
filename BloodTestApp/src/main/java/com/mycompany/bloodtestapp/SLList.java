// *Author: Soheib 
package com.mycompany.bloodtestapp;


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
    
    
    
    // recursively traverse and return the string of no-show patients
    public String listElements(Node currNode) {
        if (currNode == null) {
            return ""; // Base case for reaching the end of the list
        } else {
            Patient patient = (Patient)currNode.getElement();
            String result = "*****\nName: " + patient.getName() + "\n Age: " + patient.getAge() + "\n GP Details: " + patient.getGp()+ "\n*****";
            return result + listElements(currNode.getNext()); // recursive call
        }
    }
}
