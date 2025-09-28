package com.example.demo.dao;

import com.example.demo.dao.MyJDBC;

public class CreateTables {

    public static void run() {
        String sql = ""
                + "CREATE TABLE IF NOT EXISTS Roles ("
                + "roleId VARCHAR(50) PRIMARY KEY, "
                + "roleName VARCHAR(100) NOT NULL"
                + "); "
                + "CREATE TABLE IF NOT EXISTS Users ("
                + "userId VARCHAR(50) PRIMARY KEY, "
                + "userName VARCHAR(100) NOT NULL"
                + "); "
                + "CREATE TABLE IF NOT EXISTS UserRole ("
                + "userId VARCHAR(50) NOT NULL, "
                + "roleId VARCHAR(50) NOT NULL, "
                + "PRIMARY KEY (userId, roleId), "
                + "FOREIGN KEY (userId) REFERENCES Users(userId) ON DELETE CASCADE, "
                + "FOREIGN KEY (roleId) REFERENCES Roles(roleId) ON DELETE CASCADE"
                + ");";

        MyJDBC.executeUpdate(sql);

        System.out.println("Tables created or already exist.");
    }
}
