package Util;

import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;


public class DBConnectorTest {
    DBConnector dbConnector;
    Connection connection;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getConnection() {
        connection = DBConnector.getInstance().getConnection();
    }
}