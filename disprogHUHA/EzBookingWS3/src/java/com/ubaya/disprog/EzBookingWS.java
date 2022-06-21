/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.ubaya.disprog;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JOptionPane;
import model.administrator;
import model.mitraResto;
import model.myModel;
import model.pelanggan;
import model.reservasi;

/**
 *
 * @author Windows 10 PRO
 */
@WebService(serviceName = "EzBookingWS")
public class EzBookingWS {

    mitraResto mitra;
    pelanggan pel;
    administrator admin;
    ArrayList<String> userList;
    reservasi rsv;

    public EzBookingWS() {
        pel = new pelanggan();
        mitra = new mitraResto();
        admin = new administrator();
        userList = mitra.display();

    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrasiMitra")
    public String registrasiMitra(@WebParam(name = "namaPemilik") String namaPemilik, @WebParam(name = "namaResto") String namaResto, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "jumlahMeja") int jumlahMeja) {

        //TODO write your implementation code here:
        mitra = new mitraResto(namaPemilik, namaResto, username, password, jumlahMeja);
        mitra.insert();
        userList.add(username + "-" + password);
        return "true";

    }

    @WebMethod(operationName = "displayReservasi")
    public ArrayList<String> displayReservasi(@WebParam(name = "namaPelanggan") pelanggan namaPelanggan,
            @WebParam(name = "namaRestoran") mitraResto namaRestoran,
            @WebParam(name = "tanggalPemesanan") Date tanggalPemesanan,
            @WebParam(name = "jumlahOrang") int jumlahOrang) {
        ArrayList<String> temp = new ArrayList<>();
        reservasi res = new reservasi( namaPelanggan,  namaRestoran,  tanggalPemesanan,  jumlahOrang);
        mitra.display();
        temp.add(mitra.getUsername() + "-" + mitra.getPassword());
        return temp;
    }

    @WebMethod(operationName = "registrasiPelanggan")
    public String registrasiPelanggan(@WebParam(name = "namaPengguna") String namaPengguna, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        pel = new pelanggan(namaPengguna, username, password);
        pel.insert();
        userList.add(username + "-" + password);
        return "true";

    }
    
    @WebMethod(operationName = "registrasiAdmin")
    public String registrasiAdmin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        admin = new administrator(username, password);
        admin.insert();
        userList.add(username + "-" + password);
        return "true";
    }

    @WebMethod(operationName = ("cekLoginPelanggan"))
    public String cekLoginPelanggan(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        pel = new pelanggan(username, password);
        String cek = pel.cekLoginPelanggan(username, password);
        userList.add(username + "-" + password);
        if (cek == "ada") {
            return "ada";
        }
        return null;

    }

    @WebMethod(operationName = ("cekLoginMitra"))
    public String cekLoginMitra(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        mitra = new mitraResto(username, password);
        String cek = mitra.cekLoginMitraResto(username, password);
        userList.add(username + "-" + password);
        if (cek == "ada") {
            return "ada";
        }
        return null;
    }

    @WebMethod(operationName = ("cekLoginAdministrator"))
    public String cekLoginAdministrator(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        //TODO write your implementation code here:
        admin = new administrator(username, password);
        String cek = admin.cekLoginAdministrator(username, password);
        userList.add(username + "-" + password);
        if (cek == "ada") {
            return "ada";
        }
        return null;

    }
    @WebMethod(operationName = ("displayMitra"))
    public String displayMitra() {
        //TODO write your implementation code here:
        String display = rsv.displayMitra();
        return display;
    }
    
    
}
