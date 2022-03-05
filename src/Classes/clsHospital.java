/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Aprendiz
 */
public class clsHospital {
    
    private int id_hospital;
    private String nombre;
    private String numero;

    public clsHospital(int id_hospital, String nombre, String numero) {
        this.id_hospital = id_hospital;
        this.nombre = nombre;
        this.numero = numero;
    }

    /**
     * @return the id_hospital
     */
    public int getId_hospital() {
        return id_hospital;
    }

    /**
     * @param id_hospital the id_hospital to set
     */
    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    
    
}

