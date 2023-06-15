package com.example.testingcourseproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClientTest {
    private Client client;

    @BeforeEach
    public void setUp(){
        client = new Client("303030", "Kareem", "Addrr",
                "010044887766", "ok@ok.com",
                0.0, "kareem", "passk");
    }
    @Test
    public void createAccountTest(){
        Assertions.assertNotNull(client.getAccount());
    }

    @Test
    public void addTransactionTest(){
        client.addTransaction("deposit", 100.0);
        Assertions.assertEquals(1, client.getTransactions().size());
        Assertions.assertEquals("deposit", client.getTransactions().get(0).getType());
        Assertions.assertEquals(100.0, client.getTransactions().get(0).getAmount(), 0.01);
    }
}