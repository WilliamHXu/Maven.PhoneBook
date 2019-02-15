package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, String> directory = new TreeMap<String, String>();


    public void add(String name, String phoneNumber) {
        directory.put(name, phoneNumber);
    }

    public void remove(String name) {
        directory.remove(name);
    }

    public String lookup(String name) {
        String result = "";
        if(directory.containsKey(name)){
            result = directory.get(name);
        }
        return result;
    }


    public String reverseLookup(String phoneNumber) {
        String returnKey = "";
        Set<String> keys = directory.keySet();
        for(String k : keys){
            if (phoneNumber.equals(directory.get(k))) {
                returnKey = k;
            }
        }
        return returnKey;
    }
}
