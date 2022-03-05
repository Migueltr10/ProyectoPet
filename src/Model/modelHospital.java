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
public class modelHospital {
    DbData dbdata;

    public modelHospital() {
        this.dbdata = new DbData();
    }

    public boolean CreateHospital(clsHospital hosp){
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(),dbdata.getUser(), dbdata.getPass())){
           String query = "insert into tb_hospital(nombre,numero) values (?,?);";
           PreparedStatement statementHosp = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           statementHosp.setString(1,hosp.getNombre());
           statementHosp.setString(2,hosp.getNumero());
           
           
           int numfilas = statementHosp.executeUpdate();
           
           if(numfilas>0){
               
           }
            
            return false;
            
        }catch (SQLException e){
            return false;
        }
    }
    
    public boolean EditHospital(clsHospital hosp){
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {

            String queryDoctor = "update tb_hospital set  nombre = ?, numero = ? where id = ?";
            PreparedStatement statementHosp = connection.prepareStatement(queryDoctor);

            
            statementHosp.setString(2, hosp.getNombre());
            statementHosp.setString(1, hosp.getNumero());
            statementHosp.setInt(3, hosp.getId_hospital());
            int rowUpdatedHosp = statementHosp.executeUpdate();
            
            
            return (rowUpdatedHosp > 0);
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean DeleteHospital(clsHospital hosp){
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())){
            
            String queryDoctor = "delete from tb_hospital where id = ?;";
            PreparedStatement statementDoctor = connection.prepareStatement(queryDoctor);
            statementDoctor.setInt(1, hosp.getId_hospital());
            int rowUpdatedDoctor = statementDoctor.executeUpdate();
            
            
            return (rowUpdatedDoctor > 0);
            
        }catch (SQLException e){
            return false;
        }
    
        
    }
    
    public clsHospital BusquedaHospital(String numero){
        clsHospital hosp = null;
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_hospital where tb_hospital.numero = ?";
            PreparedStatement statementHosp = connection.prepareStatement(query);
            statementHosp.setString(1, numero);
            ResultSet result = statementHosp.executeQuery();
            while (result.next()) {
                int Id = result.getInt(1);
                String Name = result.getString(2);
                String Numero = result.getString(3);

                hosp = new clsHospital(Id, Name, Numero);
            }
            return hosp;
        } catch (Exception e) {
            return hosp;
        }
    }
    
    
    public LinkedList<clsHospital> BusquedaDHos() {
    LinkedList<clsHospital> hospitalList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_hospital; ";
            PreparedStatement statementPet = connection.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();

            while (result.next()) {
                int hospitalId = result.getInt(1);
                String hosName = result.getString(2);
                String hosNumero = result.getString(3);
                
                clsHospital hospital = new clsHospital(hospitalId, hosName, hosNumero);
                hospitalList.add(hospital);
            }

            return hospitalList;

        } catch (Exception e) {

            return hospitalList;
        }
     
    }
    
    
    
    
}
