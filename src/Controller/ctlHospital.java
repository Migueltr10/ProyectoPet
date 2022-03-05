/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.*;
import Model.*;
import java.util.LinkedList;

/**
 *
 * @author Aprendiz
 */
public class ctlHospital {

    private modelHospital modelhospital;
    
    public ctlHospital() {
        this.modelhospital = new modelHospital();
    }
    
    public boolean CreateHospital (clsHospital hosp){
        try{
            this.modelhospital.CreateHospital(hosp);
        
        return true;
        }catch(Exception e){
        return false;
        }
            
        
    }
    
    public boolean DeleteHospital (clsHospital hosp){
        try{
            this.modelhospital.DeleteHospital(hosp);
        
        return true;
        }catch(Exception e){
        return false;
        }
            
        
    }
    
    public boolean EditHospital (clsHospital hosp){
        try{
            this.modelhospital.EditHospital(hosp);
        
        return true;
        }catch(Exception e){
        return false;
        }
            
        
    }
    
    
     public clsHospital BusquedaHosp(String numero){
        
        clsHospital hosp = null;
        
         try{
            
            hosp = this.modelhospital.BusquedaHospital(numero);

            return hosp;
            
        }catch (Exception e){
            return hosp;
        }
        
        
    }
    
    public  LinkedList<clsHospital> ListHospital() {
        LinkedList<clsHospital> hospitalList = null;

        try {
            hospitalList = this.modelhospital.BusquedaDHos();
        
            return hospitalList;

        } catch (Exception e) {
            return hospitalList;
        }
    }
}
