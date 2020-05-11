/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eminsaygi.kutuphane;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Girisİslemleri {
    
    
     
     
     
   
    PreparedStatement preparedStatement = null;
    Connection connection=null;
        
public  Girisİslemleri(){  
    
       String url ="jdbc:mysql://"+Database.db_host+":"+Database.db_port+"/"+Database.db_name+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=Turkey";
        try {
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url,Database.db_user,Database.db_pass);       
        } catch (SQLException ex) {  
            
            Logger.getLogger(Girisİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }  

    
   
}
         
    public Boolean girisYap(String kullanici_adi,String parola){
        
      
             String sorgu = "Select * From adminler where username = ? and password = ? ";
        
        try {
            
            preparedStatement=connection.prepareStatement(sorgu);
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2, parola);
            
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
           
            
            return  false;
        }
       
         
    }

   
}
