/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author r_pab
 */
public class Conectar {

    public static Connection getConnection() {
        Connection c = null;
        try {
            carregaDriver();
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/academia", "postgres", "12345");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
    private static void carregaDriver(){
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
