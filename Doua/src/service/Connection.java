/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

//port java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    String url="jdbc:mysql://localhost:3306/douajavafx";
    String login="root";
    String pwd="";
    java.sql.Connection cnx;
    public static Connection instance;
    
    
    
     private Connection() {
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion réussite!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     public java.sql.Connection getCnx() {
        return cnx;
    }

    
    
     public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

}
