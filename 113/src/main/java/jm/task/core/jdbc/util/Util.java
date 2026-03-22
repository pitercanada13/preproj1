package jm.task.core.jdbc.util;


import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;


public class Util

{




        private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
        private static final String USER = "postgres";
        private static final String PASSWORD = "1";

        public static Connection getConnection() {

            try {
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Ошибка подключения к БД", e);
            }
        }
    }


