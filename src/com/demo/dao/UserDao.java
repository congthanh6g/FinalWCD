package com.demo.dao;

import com.demo.model.User;
import com.demo.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    Connection connection = ConnectionUtil.getConnection();
    public User getUser(String username , String password)
    {
        String sql = "SELECT * FROM tbuser WHERE username = ? and password =?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                User user = new User(rs.getString(1),rs.getString(2));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    public User checkAccountExists(String username)
    {
        String sql = "SELECT * FROM tbuser WHERE username = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                User user = new User(rs.getString(1),rs.getString(2));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         return null;
    }
}
