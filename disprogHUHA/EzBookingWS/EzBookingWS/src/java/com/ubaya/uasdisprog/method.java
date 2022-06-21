/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ubaya.uasdisprog;

import java.util.ArrayList;
import javax.jws.WebMethod;
import model.myModel;

/**
 *
 * @author ramad
 */
class method {
    myModel model;

    public myModel getModel() {
        return model;
    }

    public void setModel(myModel model) {
        this.model = model;
    }

    public method(myModel model) {
        this.model = model;
    }
    
    @WebMethod(operationName = "regisMitraWs")
    public String insertWs(@WebMethod(name = "NamaPemilik") String namaPemilik, 
            @WebMethod(name = "NamaRestaurant") String namaRestaurant,
            @WebMethod(name = "Username") String username) {
        //TODO write your implementation code here:
        for(int i=0; i < userList.size(); i++){//miftah-pwd; ahmad-pwdl
            String[] eachUser = userList.get(i).split("-"); //i = 0 -> miftah-pwd || i = 1 -> ahmad-pwdl
            String usr = eachUser[0];
            String pwd = eachUser[1];
            if (username.equals(usr)){
                return "false";
            }
        }
        model = new myModel(username, password);
        model.insert();
        userList.add(username+"-"+password);
        return "true";
    }
}
