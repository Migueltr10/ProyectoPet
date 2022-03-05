/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.*;
import Model.*;

/**
 *
 * @author Aprendiz
 */
public class ctlVeterinary {

    private ModelVeterinary modelveterinary;
                
    public ctlVeterinary() {
        this.modelveterinary = new ModelVeterinary();
    }
    
    public boolean CreateVeterinary(clsVeterinary veterinary){
        try{
            this.modelveterinary.CreateVeterinary((clsVeterinary)veterinary);
            
            return true;
        }catch (Exception e){
            return false;
        }
    
    }
    
    public boolean EditVeterinary(clsVeterinary veterinary){
        try{
            this.modelveterinary.EditVeterinary((clsVeterinary)veterinary);      
            
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean DeleteVeterinary(clsVeterinary veterinary){
        try{
            
            this.modelveterinary.DeleteVeterinary((clsVeterinary)veterinary);
            return true;
            
        }catch (Exception e){
            return false;
        }
    
        
    }
    
    public clsVeterinary BusquedaVeterinary(String nit){
        
        clsVeterinary veterinary = null;
        
        try{
               
            veterinary = this.modelveterinary.BusquedaVeterinary(nit);
            
        

            return veterinary;
        
        }catch (Exception e){
            return veterinary;
        }
        
        
    }
    
    
    
    
    
}
