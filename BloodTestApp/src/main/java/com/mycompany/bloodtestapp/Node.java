/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

/**
 *
 * @author Hamilton1
 */
public class Node {

    private Object element;
    private Node next;

    public Node(Object inElement, Node inNode) {
        this.element = inElement;
        this.next = inNode;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node inNode) {
        this.next = inNode;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object inElement) {
        this.element = inElement;
    }

    public String toString() {
        return element.toString();
    }
}
