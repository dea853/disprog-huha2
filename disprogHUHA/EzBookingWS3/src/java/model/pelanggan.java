/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 PRO
 */
public class pelanggan {

    int kodePelanggan;
    String namaPengguna;
    String username;
    String password;
    Connection connect;

    Statement stat;
    ResultSet resultSet;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_uasdisprog", "root", "");
        } catch (Exception e) {
            System.out.println("Error di getconnection = " + e.getMessage());
        }
        return connect;
    }

    public pelanggan(int kodePelanggan, String namaPengguna, String username, String password) {
        this.kodePelanggan = kodePelanggan;
        this.namaPengguna = namaPengguna;
        this.username = username;
        this.password = password;
        getConnection();
    }

    public pelanggan(String namaPengguna, String username, String password) {
        this.namaPengguna = namaPengguna;
        this.username = username;
        this.password = password;
        getConnection();
    }

    public pelanggan() {
        this.kodePelanggan = 0;
        this.namaPengguna = "";
        this.username = "";
        this.password = "";
        getConnection();
    }

    public pelanggan(String username, String password) {
        this.username = "";
        this.password = "";
        getConnection();
    }

    public int getKodePelanggan() {
        return kodePelanggan;
    }

    public void setKodePelanggan(int kodePelanggan) {
        this.kodePelanggan = kodePelanggan;
    }

    public String getNamaPengguna() {
        return namaPengguna;
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = namaPengguna;
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

    public void insert() {
        try {
            stat = (Statement) connect.createStatement();

            if (!connect.isClosed()) {
                PreparedStatement sql = (PreparedStatement) connect.prepareStatement("INSERT INTO pelanggan (NamaPengguna, Username, Password) values(?,?,?)");
                sql.setString(1, namaPengguna);
                sql.setString(2, username);
                sql.setString(3, password);
                sql.executeUpdate();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> display() {
        ArrayList<String> temp = new ArrayList<>();
        try {
            stat = (Statement) myModel.conn.createStatement();
            resultSet = stat.executeQuery("SELECT * FROM pelanggan");
            while (resultSet.next()) {
                pelanggan p = new pelanggan(resultSet.getInt("KodePelanggan"), resultSet.getString("NamaPengguna"),
                        resultSet.getString("Username"), resultSet.getString("Password"));
                temp.add(p.getUsername() + "-" + p.getPassword());
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
            this.resultSet = this.stat.executeQuery("SELECT * FROM pelanggan");
            while (this.resultSet.next()) {
                pelanggan pel = new pelanggan(
                        this.resultSet.getInt("KodePelanggan"),
                        this.resultSet.getString("NamaPengguna"),
                        this.resultSet.getString("Username"),
                        this.resultSet.getString("Password"));
                baca += (String.valueOf(pel.getKodePelanggan()) + "," + pel.getNamaPengguna() + "," + pel.getUsername()
                        + "," + pel.getPassword());
            }
        } catch (Exception e) {
            System.out.println("array error " + e.getMessage());
        }
        return baca;
    }

    public String cekLoginPelanggan(String username, String password) {

        String hasil = null;
        String check = "SELECT * FROM pelanggan where username='" + username + "'and password='" + password + "'";
        try {
            stat = (Statement) connect.createStatement();
            PreparedStatement sql = (PreparedStatement) connect.prepareStatement(check);
            resultSet = sql.executeQuery(check);
            if (resultSet.next()) {
                hasil = "ada";
            } 
        } catch (Exception e) {
            System.out.println("cek login gagal" + e.getMessage());
        }
        return hasil;
    }

}
