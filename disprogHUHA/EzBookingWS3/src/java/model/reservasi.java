/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 PRO
 */
public class reservasi {

    int kodeReservasi;
    //Timestamp tanggalPemesanan;
    int jumlahOrang;
    Date tanggalPemesanan;
    mitraResto mitra;
    pelanggan pelanggan;
    Statement stat;
    ResultSet result;
    Connection connect;

    public reservasi(int kodeReservasi, int jumlahOrang) {
        this.kodeReservasi = kodeReservasi;
        this.jumlahOrang = jumlahOrang;
    }
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_uasdisprog","root","");
        } catch (Exception e) {
            System.out.println("Error di getconnection = " + e.getMessage());
        }
        return connect;
    }

    public reservasi(pelanggan namaPelanggan, mitraResto namaRestoran, Date tanggalPemesanan, int jumlahOrang) {
        pelanggan nama = null;
        mitraResto namaResto = null;
        Date tanggal = null;
        int jumlah = 0;
    }

    public int getKodeReservasi() {
        return kodeReservasi;
    }

    public void setKodeReservasi(int kodeReservasi) {
        this.kodeReservasi = kodeReservasi;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

    public void insert() {
        try {
            stat = (Statement) myModel.conn.createStatement();

            if (!myModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) myModel.conn.prepareStatement("INSERT INTO reservasi (TanggalPemesanan,"
                        + " JumlahOrang, KodePelanggan, KodeMitraRestaurant) values(?,?,?,?)");
                sql.setDate(1, tanggalPemesanan);
                sql.setInt(2, jumlahOrang);
                sql.setInt(3, pelanggan.getKodePelanggan());
                sql.setInt(4, mitra.kodeResto);
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
            result = stat.executeQuery("SELECT * FROM mitrarestaurant");
            while (result.next()) {
                mitraResto mitra = new mitraResto(result.getInt("KodeRestaurant"), result.getString("NamaPemilik"),
                        result.getString("NamaRestaurant"), result.getString("Username"),
                        result.getString("Password"), result.getInt("JumlahMeja"));
                temp.add(mitra.getUsername() + "-" + mitra.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(mitraResto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public String displayMitra(){
        String list="";
        try {
            stat =  (Statement) connect.createStatement();
            result = stat.executeQuery("SELECT * FROM mitrarestaurant");
            while(result.next()){
                mitraResto mitra = new mitraResto(result.getInt("KodeRestaurant"), result.getString("NamaPemilik"),
                        result.getString("NamaRestaurant"),result.getString("Username"),
                result.getString("Password"),result.getInt("JumlahMeja"));
                list+=String.valueOf(mitra.getNamaResto());
            }
        } catch (SQLException ex) {
            Logger.getLogger(mitraResto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
