/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Windows 10 PRO
 */
public class administrator {
    
    int kodeAdministrator;
    String username;
    String password;
    
    public administrator(int kodeAdministrator, String username, String password) {
        this.kodeAdministrator = kodeAdministrator;
        this.username = username;
        this.password = password;
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

}
