/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.clsCat;
import Classes.clsDog;
import Classes.clsPet;
import Classes.clsReporteEstadoSalud;
import Classes.clsReporteRaza;
import Model.*;
import java.util.LinkedList;

/**
 *
 * @author Aprendiz
 */
public class ctlPet {

    private ModelDog modelDog;
    private ModelCat modelCat;

    public ctlPet() {
        this.modelDog = new ModelDog();
        this.modelCat = new ModelCat();
    }

   
    public boolean CreatePet(clsPet pet){
        try{
            switch (pet.getAnimalType()){
                case "Gato":
                    this.modelCat.CreatePet((clsCat) pet);
                    break;
            
                case "Perro":
                    this.modelDog.CreatePet((clsDog) pet);
                    break;
                    
            }
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    
    }
    
    public boolean EditPet(clsPet pet){
        
        try{
            switch (pet.getAnimalType()){
                case "Gato":
                    this.modelCat.EditPet((clsCat) pet);
                    break;
            
                case "Perro":
                    this.modelDog.EditPet((clsDog) pet);
                    break;
                    
            }
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean DeletePet(clsPet pet){
        
        try{
            switch (pet.getAnimalType()){
                case "Gato":
                    this.modelCat.DeletePet((clsCat) pet);
                    break;
            
                case "Perro":
                    this.modelDog.DeletePet((clsDog) pet);
                    break;
                    
            }
            
            return true;
            
        }catch (Exception e){
            return false;
        }
        
    }
    
    public clsPet BusquedaPet(String code, String type){
        
        clsPet pet = null;
        
         try{
            switch (type){
                case "Gato":
                    pet = this.modelCat.BusquedaPet(code);
                    break;
            
                case "Perro":
                    
                   pet = this.modelDog.BusquedaPet(code);
                    break;
                    
            }
            
            return pet;
            
        }catch (Exception e){
            return pet;
        }
        
        
    }
    
    public  LinkedList <clsPet> ListPet(String type) {
        LinkedList <clsPet> petList = null;

        try {
            switch (type) {
                case "Gato":
                    petList = this.modelCat.BusquedaPet2();
                    break;

                case "Perro":
                    petList = this.modelDog.BusquedaPet2();
                    break;

            }

            return petList;

        } catch (Exception e) {
            return null;
        }

    }

     public  LinkedList <clsReporteEstadoSalud> ListPetReporteSalud() {
        LinkedList <clsReporteEstadoSalud> reporte = this.modelDog.BusquedaPetEsatdoSalud();
        return reporte;
     }
     
     public  LinkedList <clsReporteEstadoSalud> ListPetReporteSaludCat() {
        LinkedList <clsReporteEstadoSalud> reporte = this.modelCat.BusquedaPetEsatdoSaludCat();
        return reporte;
     }
     
     public  LinkedList <clsReporteRaza> ListPetRaza() {
        LinkedList <clsReporteRaza> reporte = this.modelDog.BusquedaPetRazas();
        return reporte;
     }
     
     public  LinkedList <clsReporteRaza> ListPetRazaCat() {
        LinkedList <clsReporteRaza> reporte = this.modelCat.BusquedaPetRazasCat();
        return reporte;
     }
}
