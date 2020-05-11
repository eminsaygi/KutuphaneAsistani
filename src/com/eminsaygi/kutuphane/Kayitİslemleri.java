/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eminsaygi.kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emin
 */

 /**
  * Kayıt olma işlemlerini bu class'ta oluşturduk.
  */
public class Kayitİslemleri {
    
    PreparedStatement preparedStatement = null;
    Connection connection=null;
    
    /**
     * Kayıt olurken bağlantı sağlama 
     */
        
    public  Kayitİslemleri(){  
    
        String url ="jdbc:mysql://"+Database.db_host+":"+Database.db_port+"/"+Database.db_name+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=Turkey";     
        try {
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url,Database.db_user,Database.db_pass);       
        } catch (SQLException ex) {        
        }    
}
    
    /**
     * Kayıt yapma işlemi burda yapılıyor
     * @param kullanici_adi
     * @param parola
     */
    public void kayitYap (String kullanici_adi,String parola){
        
        String sorgu = "INSERT INTO adminler (username,password) VALUES (?,?)";
        
        try {
            preparedStatement = connection.prepareCall(sorgu);
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Kayitİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
