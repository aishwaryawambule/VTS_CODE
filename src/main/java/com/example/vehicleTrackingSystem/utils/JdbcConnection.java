package com.example.vehicleTrackingSystem.utils;

import com.example.vehicleTrackingSystem.entity.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aishwarya on 1/13/21.
 */
public class JdbcConnection {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcConnection.class);

    public static String DBURL;
    public static String DBUsername;
    public static String DBPassword;
    public static Connection jdbcConnection;

    /* This Function loads the properties from application.properties Property file */
    public void loadProperties(String dbType) {

            JdbcConnection.DBURL = PropertiesReader.getProperty("spring.datasource.url");
            JdbcConnection.DBUsername = PropertiesReader.getProperty("spring.datasource.username");
            JdbcConnection.DBPassword = PropertiesReader.getProperty("spring.datasource.password");
        }

        public Connection getConnection() throws SQLException, IOException, NamingException {
        try {
            /* Creation of JDBC Connection */
            LOGGER.info("Starting connection, db:" + DBURL);
            jdbcConnection = DriverManager.getConnection(DBURL, DBUsername, DBPassword);
            LOGGER.info("Connected to :" + DBURL + " DB Version:" + jdbcConnection.getMetaData().getDatabaseMajorVersion());
            LOGGER.info(" Driver Version:" + jdbcConnection.getMetaData().getDriverVersion());

        } catch (SQLException e) {

            LOGGER.error("SQLException at getConnection " + e);
        }

        return jdbcConnection;
    }

    public void closeConnection(Connection connection) throws SQLException, IOException, NamingException {
        if (connection != null) {
            connection.close();
            LOGGER.info("Connection Closed ");
        }
    }
}


