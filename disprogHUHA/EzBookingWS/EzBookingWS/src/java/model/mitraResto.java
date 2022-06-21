/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
public class mitraResto {
    int kodeResto;
    String namaPemilik;
    String namaResto;
    String username;
    String password;
    int jumlahMeja;
    
    Statement stat;
    ResultSet result;


    public mitraResto(int kodeResto, String namaPemilik, String namaResto, String username, String password, int jumlahMeja) {
        this.kodeResto = kodeResto;
        this.namaPemilik = namaPemilik;
        this.namaResto = namaResto;
        this.username = username;
        this.password = password;
        this.jumlahMeja = jumlahMeja;
    }
    
    public mitraResto() {
        this.kodeResto = 0;
        this.namaPemilik = "";
        this.namaResto = "";
        this.username = "";
        this.password = "";
        this.jumlahMeja = 0;
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
            stat = (Statement) myModel.conn.createStatement();
            
            if(!myModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) myModel.conn.prepareStatement("INSERT INTO mitrarestaurant (NamaPemilik, NamaResto,"
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
            stat =  (Statement) myModel.conn.createStatement();
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
                this.stat = (Statement) myModel.conn.createStatement();
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
}
