//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testingcourseproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    static Account test;

    public AccountTest() {
    }

    @Before
    public void testStart()
    {
        System.out.println("Starting new test...");
    }
    @Test
    public void getUsername() {
        System.out.println("Starting username getter...");
        test = new Account("admin", "password");
        String name = test.getUsername();
        Assert.assertEquals("admin", name);
    }

    @Test
    public void getPassword() {
        System.out.println("Starting password getter...");
        test = new Account("admin", "password");
        String pw = test.getPassword();
        Assert.assertEquals("password", pw);
    }

    @Test
    public void setUsername() {
        System.out.println("Starting username setter...");
        test = new Account("user", "passcode");
        test.setUsername("admin");
        String name = test.getUsername();
        Assert.assertEquals("admin", name);
    }

    @Test
    public void setPassword() {
        System.out.println("Starting password setter...");
        test = new Account("admin", "passcode");
        test.setPassword("password");
        String pw = test.getPassword();
        Assert.assertEquals("password", pw);
    }
    @After
    public void endTest()
    {
        System.out.println("Class test executed successfully\n");
    }
}
