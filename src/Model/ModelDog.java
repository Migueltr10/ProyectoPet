/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Classes.clsDog;
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
public class ModelDog {
    DbData dbdata;
    
    public ModelDog() {
        this.dbdata = new DbData();
    }
    
    public boolean CreatePet(clsDog dog){
        
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(),dbdata.getUser(), dbdata.getPass())){
           String query = "insert into tb_pet(nombre,born_year,color,healthstatus,codes) values (?,?,?,?,?);";
           PreparedStatement statementPet = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           statementPet.setString(1,dog.getName());
           statementPet.setInt(2,dog.getBorn_year());
           statementPet.setString(3,dog.getColor());
           statementPet.setString(4,dog.getHealth_status());
           statementPet.setString(5,dog.getCode());
           
           int numfilas = statementPet.executeUpdate();
           
           if(numfilas>0){
               ResultSet keys = statementPet.getGeneratedKeys();
               
               if (keys.next()){
                   int id_pet = keys.getInt(1);
                   query = "insert into tb_dog(breed,pedegree,id_pet) values (?,?,?);";
                   PreparedStatement statementDog = connection.prepareStatement(query);
                   statementDog.setString(1,dog.getBreed());
                   statementDog.setBoolean(2,dog.isPedigree());
                   statementDog.setInt(3,id_pet);
                   numfilas = statementDog.executeUpdate();
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
    
    public boolean EditPet(clsDog dog){
        
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {

            String queryPet = "update  tb_pet set codes = ?, nombre = ?, born_year = ?, color = ?, healthStatus = ? where id = ?";
            PreparedStatement statementPet = connection.prepareStatement(queryPet);

            statementPet.setString(1, dog.getCode());
            statementPet.setString(2, dog.getName());
            statementPet.setInt(3, dog.getBorn_year());
            statementPet.setString(4, dog.getColor());
            statementPet.setString(5, dog.getHealth_status());
            statementPet.setInt(6, dog.getPetId());
            int rowUpdatedPet = statementPet.executeUpdate();
            
            String queryDog = "update tb_dog set breed = ?, Pedigree = ? where id_pet = ?";
            PreparedStatement statementDog = connection.prepareStatement(queryDog);
            System.out.println("paso PreparedStatement");
            statementDog.setInt(1, dog.getDogId());
            
            
            int rowUpdatedDog = statementDog.executeUpdate();
            
            return (rowUpdatedPet > 0) && (rowUpdatedDog > 0);
        } catch (SQLException e) {
            return false;
        }
    }

    
    
    public boolean DeletePet(clsDog dog){
        
        try(Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())){
            
            String queryPet = "delete from tb_pet where id = ?;";
            PreparedStatement statementPet = connection.prepareStatement(queryPet);
            statementPet.setInt(1, dog.getPetId());
            int rowUpdatedPet = statementPet.executeUpdate();
            
            String queryDog = "delete from tb_dog where id_pet = ?;";
            PreparedStatement statementDog = connection.prepareStatement(queryDog);
            System.out.println("paso PreparedStatement");
            statementDog.setInt(1, dog.getDogId());
            int rowUpdatedDog = statementDog.executeUpdate();
            
            return (rowUpdatedPet > 0) && (rowUpdatedDog > 0);
            
        }catch (SQLException e){
            return false;
        }
    }
    
    public clsDog BusquedaPet(String code){
       clsDog dog = null;
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_pet inner join tb_dog on tb_pet.id = tb_dog.id_pet where tb_pet.codes = ?;";
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

                int dogId = result.getInt(7);
                String petBreed = result.getString(8);
                Boolean petPedigree = result.getBoolean(9);

                dog = new clsDog(dogId, petPedigree, petBreed, petId, petName, petCode, petBornYear, petColor, petHealthStatus);
            }
            return dog;
        } catch (Exception e) {
            return dog;
        }

    }

    public LinkedList<clsPet> BusquedaPet2() {
        LinkedList<clsPet> dogList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select * from tb_pet inner join tb_dog on tb_pet.id = tb_dog.id_pet;";
            PreparedStatement statementPet = connection.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();

            while (result.next()) {
                int petId = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                String petHealthStatus = result.getString(5);

                String petCode = result.getString(6);

                int dogId = result.getInt(7);
                String petBreed = result.getString(8);
                Boolean petPedigree = result.getBoolean(9);

                clsDog dog = new clsDog(dogId, petPedigree, petBreed, petId, petName, petCode, petBornYear, petColor, petHealthStatus);
                dogList.add(dog);
            }

            return dogList;

        } catch (Exception e) {

            return dogList;
        }

    }

    public LinkedList<clsReporteEstadoSalud> BusquedaPetEsatdoSalud() {
        LinkedList<clsReporteEstadoSalud> reporte = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select healthStatus, count(healthStatus) from tb_pet group by healthStatus;";
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
    
    public LinkedList<clsReporteRaza> BusquedaPetRazas() {
        LinkedList<clsReporteRaza> reporte = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(dbdata.getUrl(), dbdata.getUser(), dbdata.getPass())) {
            String query = "select breed, count(breed) from tb_dog group by breed;";
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
