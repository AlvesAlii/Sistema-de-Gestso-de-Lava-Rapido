package JDBC;

import java.sql.*;

public class ConnectionFactory {
public Connection conecta() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/lavarapido";
            String USER = "root";
            String PASSWORD = "";
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
    }

}