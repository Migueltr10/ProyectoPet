/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Classes.clsBuscarDoctor;
import Classes.clsDoctor;
import Model.*;
import java.util.LinkedList;


/**
 *
 * @author Aprendiz
 */
public class ctlDoctor {

    private ModelDoctor modeldoctor;
    
    public ctlDoctor() {
        this.modeldoctor = new ModelDoctor();
    }
    
    
    
    public boolean CreateDoctor(clsDoctor doctor){
        try{
            this.modeldoctor.CreateDoctor(doctor);
            
            return true;
        }catch (Exception e){
            return false;
        }
    
    }
    
    public boolean EditDoctor(clsBuscarDoctor doctor){
        try{
            this.modeldoctor.EditDoctor(doctor);      
            
            
            return true;
            
        }catch (Exception e){
            return false;
        }
    }
    
    public boolean DeleteDoctor(clsBuscarDoctor doctor){
        try{
            
            this.modeldoctor.DeleteDoctor(doctor);
            return true;
            
        }catch (Exception e){
            return false;
        }
    
        
    }
    
     public clsBuscarDoctor BusquedaDoctor(String nit){
        
        clsBuscarDoctor doctor = null;
        
         try{
            
            doctor = this.modeldoctor.BusquedaDoctor(nit);

            return doctor;
            
        }catch (Exception e){
            return doctor;
        }
        
        
    }
    
     public  LinkedList <clsBuscarDoctor> ListDoctor() {
        LinkedList <clsBuscarDoctor> docList = null;

        try {
            
           docList = this.modeldoctor.BusquedaDoctor1();
             
            return docList;

        } catch (Exception e) {
            return docList;
        }
    }
    
    
    
}
