//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testingcourseproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionTest {
    static Transaction test;

    public TransactionTest() {
    }
    @Before
    public void testStart()
    {
        System.out.println("Starting new test...");
    }
    @Test
    public void getId() {
        System.out.println("Starting ID getter...");
        test = new Transaction("gas", 100.0);
        int num = test.getId();
        Assert.assertEquals(2L, (long)num);
    }

    @Test
    public void getType() {
        System.out.println("Starting type getter...");
        test = new Transaction("gas", 100.0);
        String type = test.getType();
        Assert.assertEquals("gas", type);
    }

    @Test
    public void setType() {
        System.out.println("Starting type setter...");
        test.setType("gas");
        String type = test.getType();
        Assert.assertEquals("gas", type);
    }

    @Test
    public void getAmount() {
        System.out.println("Starting Amount getter...");
        test = new Transaction("gas", 100.0);
        double amount = test.getAmount();
        Assert.assertEquals(100.0, amount, 0.1);
    }

    @Test
    public void setAmount() {
        System.out.println("Starting Amount setter...");
        test.setAmount(1000.0);
        double amount = test.getAmount();
        Assert.assertEquals(1000.0, amount, 0.1);
    }

    @Test
    public void showTransaction() {
        System.out.println("Showing transactions..");
        test = new Transaction("gas", 100.0);
        String actual = "Transaction ID: " + test.getId() + ", Amount: " + test.getAmount() + ", Type: " + test.getType() + ".\n";
        String expected = "Transaction ID: 1, Amount: 100.0, Type: gas.\n";
        Assert.assertEquals(expected, actual);
    }
    @After
    public void endTest()
    {
        System.out.println("Class test executed successfully\n");
    }
}
