/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.SpringData.SpringData.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author fernan
 */
public class EncriptarPassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       var password = "1356";
        System.out.println("password: " + password);
        System.out.println("password encriptada: " + encriptarPassword(password));
    }
    public static  String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
