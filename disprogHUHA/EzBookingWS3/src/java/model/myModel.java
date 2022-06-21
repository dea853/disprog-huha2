/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Windows 10 PRO
 */
public abstract class myModel {

    public myModel(Statement statement, ResultSet resultset) {
        this.statement = statement;
        this.resultset = resultset;
        
    }
    
    public myModel(){
        this.conn = this._getConnection();
        this.statement = null;
        this.resultset = null;
        
    }
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet resultset;
    
    
    private Connection _getConnection(){
        if (myModel.conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost/db_uasdisprog","root","");
                
            } catch (Exception e) {
                System.out.println("ini gabisa");
            }
        }
        return myModel.conn;
        
    }
}



