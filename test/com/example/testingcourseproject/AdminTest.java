//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testingcourseproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdminTest {
    static Admin admin;

    public AdminTest() {
    }


    @Before
    public void testStart()
    {
        System.out.println("Starting new test...");
    }
    @Test
    public void getId() {
        System.out.println("Starting ID getter...");
        admin = new Admin("20pxxxx", "user", "password");
        String id = admin.getId();
        Assert.assertEquals("20pxxxx", id);
    }
    @Test
    public void setId()
    {
        System.out.println("Starting ID setter...");
        admin.setId("20pxxxx");
        String id = admin.getId();
        int id_len = id.length();
        Assert.assertEquals("20pxxxx", id);
        Assert.assertEquals(7, id_len);
    }

    @Test
    public void getAccount() {
        System.out.println("Starting account getter...");
        admin = new Admin("20p7732", "user", "password");
        String name = admin.getAccount().getUsername();
        String pass = admin.getAccount().getPassword();
        Assert.assertEquals("user", name);
        Assert.assertEquals("password", pass);
    }
    @After
    public void endTest()
    {
        System.out.println("Class test executed successfully\n");
    }

}
