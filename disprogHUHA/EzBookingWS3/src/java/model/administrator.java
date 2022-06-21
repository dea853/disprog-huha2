/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10 PRO
 */
public class administrator {
    
    int kodeAdministrator;
    String username;
    String password;
    
    Connection connect;

    
    Statement stat;
    ResultSet result;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_uasdisprog","root","");
        } catch (Exception e) {
            System.out.println("Error di getconnection = " + e.getMessage());
        }
        return connect;
    }
    
    public administrator(int kodeAdministrator, String username, String password) {
        this.kodeAdministrator = kodeAdministrator;
        this.username = username;
        this.password = password;
        getConnection();
    }

    public administrator(String username, String password) {
        this.username = username;
        this.password = password;
        getConnection();
    }
    
    public administrator() {
        this.kodeAdministrator = 0;
        this.username = "";
        this.password = "";
        getConnection();
    }
    public int getKodeAdministrator() {
        return kodeAdministrator;
    }

    public void setKodeAdministrator(int kodeAdministrator) {
        this.kodeAdministrator = kodeAdministrator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insert(){
        try {
            stat = (Statement) connect.createStatement();
            
            if(!connect.isClosed()){
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("INSERT INTO administrator (Username, Password)"
                        + " values(?,?)");
                sql.setString(1,username);
                sql.setString(2,password);
                sql.executeUpdate();
                
            }
        } catch (SQLException ex) {
            //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> display(){
        ArrayList<String> temp = new ArrayList<>();
        try {
            stat =  (Statement) connect.createStatement();
            result = stat.executeQuery("SELECT * FROM administrator");
            while(result.next()){
                administrator admin = new administrator(result.getInt("KodeAdministrator"), result.getString("Username"), 
                        result.getString("Password"));
                temp.add(admin.getUsername()+"-"+admin.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(mitraResto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
    
    public String viewListData() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        String baca = "";
            try {
                this.stat = (Statement) connect.createStatement();
                this.result = this.stat.executeQuery("SELECT * FROM administrator");
                while (this.result.next()) {
                    administrator admin = new administrator(
                            this.result.getInt("KodeAdministrator"),
                            this.result.getString("Username"),
                            this.result.getString("Password"));
                    baca+=(String.valueOf(admin.getKodeAdministrator())+ "," +admin.getUsername()+ "," 
                            + admin.getPassword());
                }
            } catch (Exception e) {
                System.out.println("array error " + e.getMessage());
            }
            return baca;
        }
    
    public String cekLoginAdministrator(String username, String password) {

        String hasil = null;
        String check = "SELECT * FROM administrator where username='" + username + "'and password='" + password + "'";
        try {
            stat = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(check);
            result = sql.executeQuery(check);
            if (result.next()) {
                hasil = "ada";
            }
        } catch (Exception e) {
            System.out.println("cek login gagal" + e.getMessage());
        }
        return hasil;
    }
}
