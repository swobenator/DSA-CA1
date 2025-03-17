/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bloodtestapp;

/**
 *
 * @author Hamilton1
 */
public interface LinearListInterface {

    public boolean isEmpty();

    public int size();

    public Object get(int index);

    public void remove(int index);

    public void add(int index, Object theElement);

    public void add(Object element);

    public String listNoShows();
}
