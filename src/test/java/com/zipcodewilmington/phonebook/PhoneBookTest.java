package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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

        ArrayList<String> expected = new ArrayList<>();
        expected.add(phoneNumber);
        ArrayList<String> actual = phoneBook.lookup(name);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";
        String name2 = "Bob";
        String phoneNumber2 = "302-293-3575";
        String phoneNumber3 = "302-293-3185";

        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, phoneNumber2);
        phoneBook.add(name2, phoneNumber3);

        phoneBook.remove(phoneNumber2);

        ArrayList<String> expected = new ArrayList<>();
        expected.add(phoneNumber);
        ArrayList<String> actual = phoneBook.lookup(name);
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add(phoneNumber3);
        ArrayList<String> actual2 = phoneBook.lookup(name2);
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
    }


    @Test
    public void removeRecordTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";
        String name2 = "Bob";
        String phoneNumber2 = "302-293-3575";

        phoneBook.add(name, phoneNumber);
        phoneBook.add(name2, phoneNumber2);

        phoneBook.removeRecord(name);

        ArrayList<String> expected = new ArrayList<>();
        expected.add(phoneNumber2);
        ArrayList<String> actual = phoneBook.lookup(name);
        ArrayList<String> actual2 = phoneBook.lookup(name2);
        Assert.assertEquals(expected, actual2);
        Assert.assertNull(actual);
    }


    @Test
    public void lookupTest(){
        String name = "Will";
        String phoneNumber = "302-293-1456";

        phoneBook.add(name, phoneNumber);
        String falseName = "Bob";
        ArrayList<String> actual = phoneBook.lookup(falseName);
        Assert.assertNull(actual);
    }

    @Test
    public void lookupTest2(){
        String name = "Will";
        String phoneNumber = "302-293-1456";

        phoneBook.add(name, phoneNumber);

        ArrayList<String> expected = new ArrayList<>();
        expected.add(phoneNumber);
        ArrayList<String> actual = phoneBook.lookup(name);
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



        String expected = "Bob 302-293-3575 " + "\n" + "Will 302-293-1456 \n\n";
        String actual = outContent.toString();

        Assert.assertEquals(expected, actual);
    }

}
