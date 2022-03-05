/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Classes.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Aprendiz
 */
public class ModelDoctor {
    DbData dbdata;

    public ModelDoctor() {
        this.dbdata = new DbData();
    }
    
    
    
        public boolean CreateDoctor(clsDoctor doctor){
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(),dbdata.getUser(), dbdata.getPass())){
           String query = "insert into tb_doctor(nombre,address,phone,documento,tipo_documento,id_hospital) values (?,?,?,?,?,?);";
           PreparedStatement statementDoctor = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           statementDoctor.setString(1,doctor.getName());
           statementDoctor.setString(2,doctor.getAddress());
           statementDoctor.setString(3,doctor.getPhone());
           statementDoctor.setString(4,doctor.getDocumento());
           statementDoctor.setString(5, "CC");
           statementDoctor.setInt(6, doctor.getId_doctor());

           
           int numfilas = statementDoctor.executeUpdate();
           
           if(numfilas>0){
               
               
                return true;
                   
           }
            
         
            
        }catch (SQLException e){
            return false;
        }
         return false;
    }
    
    public boolean EditDoctor(clsBuscarDoctor doctor){
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {

            String queryDoctor = "update tb_doctor set nombre = ?, address = ?, phone = ?, tipo_documento = ?, id_hospital = ?, documento = ? where id = ?";
            PreparedStatement statementDoctor = connection.prepareStatement(queryDoctor);
            
            
            statementDoctor.setString(1, doctor.getNombredoc());
            statementDoctor.setString(2, doctor.getAddress());
            statementDoctor.setString(3, doctor.getPhone());
            statementDoctor.setString(4, "CC");
            statementDoctor.setInt(5, doctor.getIdhosp());
            statementDoctor.setString(6, doctor.getDocumento());
            statementDoctor.setInt(7, doctor.getIddoctor());
            
            int rowUpdatedDoctor = statementDoctor.executeUpdate();
            
            
            return (rowUpdatedDoctor > 0);
            
           
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean DeleteDoctor(clsBuscarDoctor doctor){
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())){
            
            String queryDoctor = "delete from tb_doctor where Id = ?";
            PreparedStatement statementDoctor = connection.prepareStatement(queryDoctor);
            statementDoctor.setInt(1, doctor.getIddoctor());
            int rowUpdatedDoctor = statementDoctor.executeUpdate();
            
            
            return (rowUpdatedDoctor > 0);
            
        }catch (SQLException e){
            return false;
        }
    
        
    }
    
    public clsBuscarDoctor BusquedaDoctor(String nit){
       clsBuscarDoctor doctor = null;
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_hospital inner join tb_doctor on tb_hospital.id = tb_doctor.id_hospital where documento = ?";
            PreparedStatement statementDoctor = connection.prepareStatement(query);
            statementDoctor.setString(1, nit);
            ResultSet result = statementDoctor.executeQuery();
            while (result.next()) {
                
                int docId = result.getInt(1);
                String NomHab = result.getString(2);
                
                String NumHab = result.getString(3);
                int ID = result.getInt(4);
                String Name = result.getString(5);
                String Address = result.getString(6);
                String Phone = result.getString(7);
               
                
                
                doctor = new clsBuscarDoctor(docId,NomHab, NumHab, ID, Name, Address, Phone, Name);
            }
            return doctor;
        } catch (Exception e) {
            return doctor;
        } 
        

    }
    
    public LinkedList<clsBuscarDoctor> BusquedaDoctor1(){
        LinkedList<clsBuscarDoctor> docList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_hospital inner join tb_doctor on tb_hospital.id= tb_doctor.id_hospital";
            PreparedStatement statementDoctor = connection.prepareStatement(query);
            ResultSet result = statementDoctor.executeQuery();
            while (result.next()) {
                
                
                int docId = result.getInt(1);
                String NomHab = result.getString(2);
                
                String NumHab = result.getString(3);
                
                String Name = result.getString(5);
                String Address = result.getString(6);
                String Phone = result.getString(7);
                String Documento = result.getString(8);
                
                clsBuscarDoctor doctor = new clsBuscarDoctor(0,NomHab, NumHab, docId, Name, Address, Phone, Documento);
                docList.add(doctor);
            }
            return docList;
        } catch (Exception e) {
            return docList;
        } 
        

    }
    
    public LinkedList<clsBuscarDoctor> BusquedaDoc2() {
        LinkedList<clsBuscarDoctor> List = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_doctor inner join tb_hospital on tb_doctor.id_hospital= tb_hospital.id";
            PreparedStatement statementDoc = connection.prepareStatement(query);
            ResultSet result = statementDoc.executeQuery();

            while (result.next()) {
                 int docId = result.getInt(1);
                String NomHab = result.getString(2);
                
                String NumHab = result.getString(3);
                
                String Name = result.getString(5);
                String Address = result.getString(6);
                String Phone = result.getString(7);
                String Documento = result.getString(8);
                clsBuscarDoctor doc= new clsBuscarDoctor(0,NomHab, NumHab, docId, Name, Address, Phone, Documento);
                List.add(doc);
            }

            return List;

        } catch (Exception e) {

            return List;
        }

    }
    
    /*public clsBuscarDoctor BusquedaDoctor1(String nit) {
        clsBuscarDoctor doctor = null;
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_doctor inner join tb_hospital on tb_doctor.id_hospital = tb_hospital.id where tb_doctor.documento = ?;";
            PreparedStatement statementDoctor = connection.prepareStatement(query);
            statementDoctor.setString(1, nit);
            ResultSet result = statementDoctor.executeQuery();
            while (result.next()) {
                
                String Name = result.getString(1);
                String Address = result.getString(2);
                String Phone = result.getString(3);
                String Documento = result.getString(4);
                int docId = result.getInt(5);
                String NumHab = result.getString(6);
                String NomHab = result.getString(7);
                int hospitalId = result.getInt(8);
                

                doctor = new clsBuscarDoctor(hospitalId, NumHab, NomHab, docId, Name, Address, Phone, Documento);
            }
            return doctor;
        } catch (Exception e) {
            return doctor;
        } 
    }*/
       
    
}
