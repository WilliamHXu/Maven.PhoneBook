package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBookTest {

    private PhoneBook phoneBook;
    @Before
    public void setup(){
        phoneBook = new PhoneBook();
    }

    @Test
    public void addTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";

        phoneBook.add(name, phoneNumber);

        String actual = phoneBook.lookup(name);
        Assert.assertEquals(phoneNumber, actual);
    }

    @Test
    public void removeTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";
        String name2 = "Bob";
        String phoneNumber2 = "302-293-3575";

        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, phoneNumber2);

        phoneBook.remove(name);

        String expected = "";
        String actual = phoneBook.lookup(name);
        String actual2 = phoneBook.lookup(name2);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(phoneNumber2, actual2);
    }


    @Test
    public void lookupTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";

        phoneBook.add(name, phoneNumber);
        String falseName = "Bob";
        String expected = "";
        String actual = phoneBook.lookup(falseName);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseLookupTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";

        phoneBook.add(name, phoneNumber);

        String actual = phoneBook.reverseLookup(phoneNumber);
        Assert.assertEquals(name, actual);
    }

    @Test
    public void displayTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";
        String name2 = "Bob";
        String phoneNumber2 = "302-293-3575";

        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, phoneNumber2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        phoneBook.display();

        String expected = "" + name2 + " " + phoneNumber2 + "\n" + name + " " + phoneNumber + "\n\n";
        String actual = outContent.toString();

        Assert.assertEquals(expected, actual);
    }
}
