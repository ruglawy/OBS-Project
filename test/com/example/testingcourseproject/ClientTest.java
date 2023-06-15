//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.testingcourseproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    static Client client;
    static Client client2;
    static Client client3;
    static Account acc;

    public ClientTest() {
    }
    @Before
    public void testStart()
    {
        System.out.println("Starting new test...");
    }
    @Test
    public void createAccount() {
        System.out.println("Starting account creation test...");
        client.createAccount("name", "password");
        String name = client.getAccount().getUsername();
        String pw = client.getAccount().getPassword();
        Assert.assertEquals("name", name);
        Assert.assertEquals("password", pw);
    }

    @Test
    public void addTransaction() {
        System.out.println("Starting transaction addition...");
        client.addTransaction("gas", 100.5);
        client.addTransaction("electricity", 200.0);
        client.addTransaction("rent", 1000.0);
        Assert.assertEquals("rent", ((Transaction)client.getTransactions().get(2)).getType());
        Assert.assertEquals(100.5, ((Transaction)client.getTransactions().get(0)).getAmount(), 0.1);
    }

    @Test
    public void getId() {
        System.out.println("Starting ID getter...");
        client = new Client("20pxxxx", "name", "cairo", "01xxxxxxxxx", "test@gmail.com", 2000.0, "user", "password");
        String id = client.getId();
        Assert.assertEquals("20pxxxx", id);
    }

    @Test
    public void setId() {
        System.out.println("Starting ID setter...");
        client.setId("20pxxxx");
        String id = client.getId();
        int id_len = id.length();
        Assert.assertEquals("20pxxxx", id);
        Assert.assertEquals(7L, (long)id_len);
    }

    @Test
    public void getName() {
        System.out.println("Starting Name getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "01099243030", "test@gmail.com", 2000.0, "user", "password");
        String name = client.getName();
        Assert.assertEquals("mohamed", name);
    }

    @Test
    public void setName() {
        System.out.println("Starting Name setter...");
        client.setName("ramzi");
        String name = client.getName();
        Assert.assertEquals("ramzi", name);
    }

    @Test
    public void getAddress() {
        System.out.println("Starting Address getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "01099243030", "test@gmail.com", 2000.0, "user", "password");
        String address = client.getAddress();
        Assert.assertEquals("cairo", address);
    }

    @Test
    public void setAddress() {
        System.out.println("Starting Address setter...");
        client.setAddress("cairo");
        String address = client.getAddress();
        Assert.assertEquals("cairo", address);
    }

    @Test
    public void getPhoneNumber() {
        System.out.println("Starting Phone number getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        String p_num = client.getPhoneNumber();
        Assert.assertEquals("12345", p_num);
    }

    @Test
    public void setPhoneNumber() {
        System.out.println("Starting Phone number setter...");
        client.setPhoneNumber("01xxxxxxxxx");
        String p_num = client.getPhoneNumber();
        int p_num_length = p_num.length();
        Assert.assertEquals("01xxxxxxxxx", p_num);
        Assert.assertEquals(11L, (long)p_num_length);
    }

    @Test
    public void getEmail() {
        System.out.println("Starting email getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        String email = client.getEmail();
        Assert.assertEquals("test@gmail.com", email);
    }

    @Test
    public void setEmail() {
        System.out.println("Starting email setter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        client.setEmail("test@icloud.com");
        String email = client.getEmail();
        Assert.assertEquals("test@icloud.com", email);
    }

    @Test
    public void getBalance() {
        System.out.println("Starting balance getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        double balance = client.getBalance();
        Assert.assertEquals(2000.0, balance, 0.1);
    }

    @Test
    public void setBalance() {
        System.out.println("Starting balance setter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        client.setBalance(3000.0);
        double balance = client.getBalance();
        Assert.assertEquals(3000.0, balance, 0.1);
    }

    @Test
    public void getAccount() {
        System.out.println("Starting Account getter...");
        client = new Client("20pxxxx", "mohamed", "cairo", "12345", "test@gmail.com", 2000.0, "user", "password");
        String name_acc = client.getAccount().getUsername();
        String pw_acc = client.getAccount().getPassword();
        Assert.assertEquals("user", name_acc);
        Assert.assertEquals("password", pw_acc);
    }

    @Test
    public void setAccount() {
        System.out.println("Starting Account setter...");
        acc = new Account("user", "password");
        client.setAccount(acc);
        String name_acc = client.getAccount().getUsername();
        String pw_acc = client.getAccount().getPassword();
        Assert.assertEquals("user", name_acc);
        Assert.assertEquals("password", pw_acc);
    }

    @Test
    public void getTransactions() {
        System.out.println("Starting Transactions getter...");
        client2 = new Client("20pxxxx", "mohamed", "cairo", "01099243030", "test@gmail.com", 2000.0, "user", "password");
        client2.addTransaction("gas", 100.0);
        client2.addTransaction("electricity", 200.0);
        client2.addTransaction("rent", 1000.0);
        Assert.assertEquals(3L, (long)client2.getTransactions().size());
    }
    @After
    public void endTest()
    {
        System.out.println("Class test executed successfully\n");
    }
}
