/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Classes.clsCat;
import Classes.clsPet;
import Classes.clsReporteEstadoSalud;
import Classes.clsReporteRaza;
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
public class ModelCat {
    DbData dbdata;
    
    public ModelCat() {
        this.dbdata = new DbData();
    }
    
   
    
    public boolean CreatePet(clsCat cat){
        
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(),dbdata.getUser(), dbdata.getPass())){
           String query = "insert into tb_pet(nombre,born_year,color,healthstatus,codes) values (?,?,?,?,?);";
           PreparedStatement statementPet = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           statementPet.setString(1,cat.getName());
           statementPet.setInt(2,cat.getBorn_year());
           statementPet.setString(3,cat.getColor());
           statementPet.setString(4,cat.getHealth_status());
           statementPet.setString(5,cat.getCode());
           
           int numfilas = statementPet.executeUpdate();
           
           if(numfilas>0){
               ResultSet keys = statementPet.getGeneratedKeys();
               
               if (keys.next()){
                   int id_pet = keys.getInt(1);
                   query = "insert into tb_cat(breed,id_pet) values (?,?);";
                   PreparedStatement statementCat = connection.prepareStatement(query);
                   statementCat.setString(1,cat.getBreed());
                   statementCat.setInt(2,id_pet);
                   numfilas = statementCat.executeUpdate();
                   if(numfilas>0){
                       return true;
                   }
               }
           }
            
            return false;
            
        }catch (SQLException e){
            return false;
        }
        
    }
    
    public boolean EditPet(clsCat cat){
        
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {

            String queryPet = "update  tb_pet set codes = ?, nombre = ?, born_year = ?, color = ?, healthStatus = ? where id = ?";
            PreparedStatement statementPet = connection.prepareStatement(queryPet);

            statementPet.setString(1, cat.getCode());
            statementPet.setString(2, cat.getName());
            statementPet.setInt(3, cat.getBorn_year());
            statementPet.setString(4, cat.getColor());
            statementPet.setString(5, cat.getHealth_status());
            statementPet.setInt(6, cat.getPetId());
            int rowUpdatedPet = statementPet.executeUpdate();
            
            String queryCat = "update tb_cat set breed = ? where id_pet = ?";
            PreparedStatement statementCat = connection.prepareStatement(queryCat);
            System.out.println("paso PreparedStatement");
            statementCat.setInt(1, cat.getCatId());
            
            int rowUpdatedCat = statementCat.executeUpdate();
            
            return (rowUpdatedPet > 0) && (rowUpdatedCat > 0);
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean DeletePet(clsCat cat){
        
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())){
            
            String queryPet = "delete from tb_pet where id = ?;";
            PreparedStatement statementPet = connection.prepareStatement(queryPet);
            statementPet.setInt(1, cat.getPetId());
            int rowUpdatedPet = statementPet.executeUpdate();
            
            String queryCat = "delete from tb_cat where id_pet = ?;";
            PreparedStatement statementCat = connection.prepareStatement(queryCat);
            System.out.println("paso PreparedStatement");
            statementCat.setInt(1, cat.getCatId());
            int rowUpdatedCat = statementCat.executeUpdate();
            
            return (rowUpdatedPet > 0) && (rowUpdatedCat > 0);
            
        }catch (SQLException e){
            return false;
        }
    }
    
    public clsCat BusquedaPet(String code){
       
        clsCat cat = null;
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_pet inner join tb_cat on tb_pet.id = tb_cat.id_pet where tb_pet.codes = ?";
            PreparedStatement statementPet = connection.prepareStatement(query);
            statementPet.setString(1, code);
            ResultSet result = statementPet.executeQuery();
            while (result.next()) {
                int petId = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                String petHealthStatus = result.getString(5);

                String petCode = result.getString(6);

                int catId = result.getInt(7);
                String petBreed = result.getString(8);

                cat = new clsCat(catId, petBreed, petId, petName, petCode, petBornYear, petColor, petHealthStatus);
            }
            return cat;
        } catch (Exception e) {
            return cat;
        }

    }

    public LinkedList<clsPet> BusquedaPet2() {
        LinkedList<clsPet> catList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_pet inner join tb_cat on tb_pet.id = tb_cat.id_pet;";
            PreparedStatement statementPet = connection.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();

            while (result.next()) {
                int petId = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                String petHealthStatus = result.getString(5);

                String petCode = result.getString(6);

                int catId = result.getInt(7);
                String petBreed = result.getString(8);

                clsCat cat = new clsCat(catId, petBreed, petId, petName, petCode, petBornYear, petColor, petHealthStatus);
                catList.add(cat);
            }

            return catList;

        } catch (Exception e) {

            return catList;
        }

    }
    
    public LinkedList<clsReporteEstadoSalud> BusquedaPetEsatdoSaludCat() {
        LinkedList<clsReporteEstadoSalud> reporte = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select healthStatus, count(healthStatus) from tb_pet inner join tb_cat on tb_pet.id = tb_cat.id_pet group by healthStatus;";
            PreparedStatement statementPet = connection.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();

            while (result.next()) {
                
                clsReporteEstadoSalud rep = new clsReporteEstadoSalud();
                
                String estadosalud = result.getString(1);
                int conteo = result.getInt(2);
                rep.setEstadosalud(estadosalud);
                rep.setContadordeestados(conteo);
                reporte.add(rep);
            }

            return reporte;

        } catch (Exception e) {

            return reporte;
        }

    }
    
    public LinkedList<clsReporteRaza> BusquedaPetRazasCat() {
        LinkedList<clsReporteRaza> reporte = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select breed, count(breed) from tb_cat group by breed;";
            PreparedStatement statementPet = connection.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();

            while (result.next()) {
                
                clsReporteRaza rep = new clsReporteRaza();
                
                String raza = result.getString(1);
                int conteo = result.getInt(2);
                rep.setRazas(raza);
                rep.setContadorrazas(conteo);
                reporte.add(rep);
            }

            return reporte;

        } catch (Exception e) {

            return reporte;
        }

    }

    
  
}
