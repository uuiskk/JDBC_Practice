package com.nhnacademy.jdbc.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicConnectionPoolTest {

    static BasicConnectionPool basicConnectionPool;
    @BeforeEach
    static void setUp() {
       // basicConnectionPool = new BasicConnectionPool(com.mysql.cj.jdbc.Driver.class.getName(),"jdbc:","nhn_academy_0",)
    }

    @Test
    void getConnection() {
    }

    @Test
    void releaseConnection() {
    }

    @Test
    void size() {
    }
}