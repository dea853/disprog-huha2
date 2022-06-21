/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
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
    
    Statement stat;
    ResultSet resultSet;
    
    public pelanggan(int kodePelanggan, String namaPengguna, String username, String password) {
        this.kodePelanggan = kodePelanggan;
        this.namaPengguna = namaPengguna;
        this.username = username;
        this.password = password;
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

    public void insert(){
        try {
            stat = (Statement) myModel.conn.createStatement();
            
            if(!myModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) myModel.conn.prepareStatement("INSERT INTO pelanggan (NamaPengguna, Username, Password) values(?,?,?)");
                sql.setInt(1, kodePelanggan);
                sql.setString(2, namaPengguna);
                sql.setString(3, username);
                sql.setString(4, password);
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
            resultSet = stat.executeQuery("SELECT * FROM pelanggan");
            while(resultSet.next()){
                pelanggan p = new pelanggan(resultSet.getInt("KodePelanggan"), resultSet.getString("NamaPengguna"), 
                        resultSet.getString("Username"),resultSet.getString("Password"));
                temp.add(p.getUsername()+"-"+p.getPassword());
            }
        } catch (SQLException ex) {
            Logger.getLogger(mitraResto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
}
