/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import Classes.clsVeterinary;

/**
 *
 * @author Aprendiz
 */
public class ModelVeterinary {
    
    
    public boolean CreateVeterinary(clsVeterinary veterinary){
        try{
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    
    }
    
    public boolean EditVeterinary(clsVeterinary veterinary){
        try{
            return true;
            
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean DeleteVeterinary(clsVeterinary veterinary){
        try{
            return true;
            
        }catch (Exception e){
            return false;
        }
    
        
    }
    
    public clsVeterinary BusquedaVeterinary(String nit){
        
        clsVeterinary veterinary = null;
        
        try{
            return veterinary;
 
        }catch(Exception e){
            return veterinary;
        }
        
        
    }
    
    
    
}
