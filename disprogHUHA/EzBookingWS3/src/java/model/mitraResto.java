/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 PRO
 */
public class mitraResto{
    int kodeResto;
    String namaPemilik;
    String namaResto;
    String username;
    String password;
    int jumlahMeja;
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
    
    public mitraResto(int kodeResto, String namaPemilik, String namaResto, String username, String password, int jumlahMeja) {
        this.kodeResto = kodeResto;
        this.namaPemilik = namaPemilik;
        this.namaResto = namaResto;
        this.username = username;
        this.password = password;
        this.jumlahMeja = jumlahMeja;
        getConnection();
    }
    
    public mitraResto(String namaPemilik, String namaResto, String username, String password, int jumlahMeja) {
        this.namaPemilik = namaPemilik;
        this.namaResto = namaResto;
        this.username = username;
        this.password = password;
        this.jumlahMeja = jumlahMeja;
        getConnection();
    }
    
    
    public mitraResto(String username, String password) {
        this.username = username;
        this.password = password;
        getConnection();
    }
    public mitraResto() {
        this.kodeResto = 0;
        this.namaPemilik = "";
        this.namaResto = "";
        this.username = "";
        this.password = "";
        this.jumlahMeja = 0;
        getConnection();
    }

    public int getKodeResto() {
        return kodeResto;
    }

    public void setKodeResto(int kodeResto) {
        this.kodeResto = kodeResto;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public String getNamaResto() {
        return namaResto;
    }

    public void setNamaResto(String namaResto) {
        this.namaResto = namaResto;
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

    public int getJumlahMeja() {
        return jumlahMeja;
    }

    public void setJumlahMeja(int jumlahMeja) {
        this.jumlahMeja = jumlahMeja;
    }
    
    public void insert(){
        try {
            stat = (Statement) connect.createStatement();
            
            if(!connect.isClosed()){
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("INSERT INTO mitrarestaurant (NamaPemilik, NamaRestaurant,"
                        + "Username, Password, JumlahMeja) values(?,?,?,?,?)");
                sql.setString(1,namaPemilik);
                sql.setString(2,namaResto);
                sql.setString(3,username);
                sql.setString(4,password);
                sql.setInt(5,jumlahMeja);
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
            result = stat.executeQuery("SELECT * FROM mitrarestaurant");
            while(result.next()){
                mitraResto mitra = new mitraResto(result.getInt("KodeRestaurant"), result.getString("NamaPemilik"), 
                        result.getString("NamaRestaurant"),result.getString("Username"),
                result.getString("Password"),result.getInt("JumlahMeja"));
                temp.add(mitra.getUsername()+"-"+mitra.getPassword());
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
                this.result = this.stat.executeQuery("SELECT * FROM mitrarestaurant");
                while (this.result.next()) {
                    mitraResto mitra = new mitraResto(
                            this.result.getInt("KodeResto"),
                            this.result.getString("NamaPemilik"),
                            this.result.getString("NamaResto"),
                            this.result.getString("Username"),
                            this.result.getString("Password"),
                            this.result.getInt("JumlahMeja"));
                    baca+=(String.valueOf(mitra.getKodeResto())+ "," +mitra.getNamaPemilik() + "," + mitra.getNamaResto()+ "," +mitra.getUsername()
                            + "," +mitra.getPassword() +"," +String.valueOf(mitra.getJumlahMeja()));
                }
            } catch (Exception e) {
                System.out.println("array error " + e.getMessage());
            }
            return baca;
        }
    
    public String cekLoginMitraResto(String username, String password) {

        String hasil = null;
        String check = "SELECT * FROM mitrarestaurant where username='" + username + "'and password='" + password + "'";
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
