package com.demo.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static Connection connection;

    public synchronized static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/fdata";
        String user = "root";
        String password = "";
        if (connection == null)
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url , user , password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection()
    {
        try {
            connection.close();
            connection = null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally
        {
            connection = null;
        }
    }

}