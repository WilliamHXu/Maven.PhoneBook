package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList<String>> directory = new TreeMap<>();


    public void add(String name, String phoneNumber) {
        if(directory.containsKey(name)) {
            ArrayList<String> numbersAL = directory.get(name);
            numbersAL.add(phoneNumber);
            directory.put(name, numbersAL);
        }
        else{
            ArrayList<String> numbersAL2 = new ArrayList<>();
            numbersAL2.add(phoneNumber);
            directory.put(name, numbersAL2);
        }
    }

    public void remove(String phoneNumber) {
        Set<String> keys = directory.keySet();
        for(String k : keys){
            ArrayList<String> numbers = directory.get(k);
            directory.replace(k, deleteInNumbers(numbers, phoneNumber));
        }
    }

    private ArrayList<String> deleteInNumbers(ArrayList<String> numbers, String phoneNumber) {
        ArrayList<String> returnNumbers = numbers;
        for(String s : returnNumbers){
            if(s.equals(phoneNumber)){
                returnNumbers.remove(s);
            }
        }
        return returnNumbers;
    }

    public void removeRecord(String name) {
        directory.remove(name);
    }

    public ArrayList<String> lookup(String name) {
        ArrayList<String> result = null;
        if(directory.containsKey(name)){
            result = directory.get(name);
        }
        return result;
    }


    public String reverseLookup(String phoneNumber) {
        String returnKey = "";
        Set<String> keys = directory.keySet();
        for(String k : keys){
            ArrayList<String> numbers = directory.get(k);
            if (containsNumberInValue(numbers, phoneNumber)) {
                returnKey = k;
            }
        }
        return returnKey;
    }

    private boolean containsNumberInValue(ArrayList<String> numbers, String phoneNumber) {
        boolean ret = false;
        for(String s : numbers){
            if(s.equals(phoneNumber)){
                ret = true;
            }
        }
        return ret;
    }

    public void display(){
        String outDisplay = "";
        Set<String> keys = directory.keySet();
        for(String k : keys){
            ArrayList<String> numbersAL = this.lookup(k);
            outDisplay += k + " ";
            for (String s: numbersAL) {
                outDisplay += s + " ";
            }
            outDisplay += "\n";
        }
        System.out.println(outDisplay);
    }
}
