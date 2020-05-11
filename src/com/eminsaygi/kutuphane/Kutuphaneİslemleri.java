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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emin
 */
public class Kutuphaneİslemleri {
        
    private Connection connection=null;
    private Statement  statement=null;
    private PreparedStatement preparedStatement=null;
    
    
    /*
    Kutuphane işlemlerini yaparken bağlantı sağlıyoruz.
    */
    public Kutuphaneİslemleri(){     
        
      
        
      
       
         String url ="jdbc:mysql://"+Database.db_host+":"+Database.db_port+"/"+Database.db_name+"?useUnicode=true&characterEncoding=utf-8&serverTimezone=Turkey";  
     try {
         
         connection = (Connection) DriverManager.getConnection(url,Database.db_user,Database.db_pass);
         
     } catch (SQLException ex) {      
           Logger.getLogger(Kutuphaneİslemleri.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }
    /*
    Tablodan Kitap Verilerini burdan  güncelliyoruz.
    */
    public void kitapGuncelle (int id,String yeni_ad,String yeni_yazar,String yeni_tür,String yeni_cevirmen){
        
        String sorgu = "Update kitaplar set adi = ? , yazar = ? , tur = ? , cevirmen = ? where id = ? ";
        
         try {
             preparedStatement = connection.prepareStatement(sorgu);
             
             preparedStatement.setString(1,yeni_ad);
             preparedStatement.setString(2, yeni_yazar);
             preparedStatement.setString(3, yeni_tür);
             preparedStatement.setString(4, yeni_cevirmen);
             
             preparedStatement.setInt(5, id);
             
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Kutuphaneİslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    /*
    Tablodan kitap verilerini burdan siliyoruz.
    */
   public  void kitapSil(int id){
       
       
       String sorgu = "Delete from kitaplar where id = ?";
       
         try {
             preparedStatement = connection.prepareCall(sorgu);
             preparedStatement.setInt(1, id);
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(Kutuphaneİslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
       
   }
   /*
   Tabloya yeni kitap ekleme işlemini burda yapıyoruz.
   */
    public void  kitapEkle(String adı,String yazar,String tür,String cevirmen){
       

        String sorgu = "INSERT INTO kitaplar (adi,yazar,tur,cevirmen) VALUES (?, ?, ?, ?)";
        
         try {
             preparedStatement = connection.prepareCall(sorgu);
             preparedStatement.setString(1,adı);
             preparedStatement.setString(2,yazar);
             preparedStatement.setString(3, tür);
             preparedStatement.setString(4,cevirmen);
             
             preparedStatement.executeUpdate();
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(Kutuphaneİslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
    }
    /*
    Mysql databesten aldığımız verileri tabloya aktarıyoruz.
    */
    public ArrayList<Kitap> kitaplariGoster(){
        
        ArrayList<Kitap> cikti = new ArrayList<Kitap>();
        
         try {
             statement = connection.createStatement();
             
             String sorgu = "Select * From kitaplar";
             
             ResultSet rs = statement.executeQuery(sorgu);
             
             while (rs.next()) {                 
                 
                 int id = rs.getInt("id");
                 String adi=rs.getString("adi");
                 String yazar = rs.getString("yazar");
                 String tur = rs.getString("tur");
                 String cevirmen = rs.getString("cevirmen");
                 
                 cikti.add(new Kitap(id, adi, yazar, tur, cevirmen));
                 
             }
             
             return cikti;
             
         } catch (SQLException ex) {
             Logger.getLogger(Kutuphaneİslemleri.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
        
        
    }
    
}
