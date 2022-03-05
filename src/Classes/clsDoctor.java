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
public class clsDoctor {
    
    private String name;
    private String documento;
    private String address;
    private String phone;
    private int id_doctor;
    private clsVeterinary veterinaria;

    public clsDoctor(String name, String documento, String address, String phone, int id_doctor) {
        this.name = name;
        this.documento = documento;
        this.address = address;
        this.phone = phone;
        this.id_doctor = id_doctor;
    }
   
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    

    /**
     * @return the veterinaria
     */
    public clsVeterinary getVeterinaria() {
        return veterinaria;
    }

    /**
     * @param veterinaria the veterinaria to set
     */
    public void setVeterinaria(clsVeterinary veterinaria) {
        this.veterinaria = veterinaria;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the nit
     */
    
    /**
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the id_doctor
     */
    public int getId_doctor() {
        return id_doctor;
    }

    /**
     * @param id_doctor the id_doctor to set
     */
    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    /**
     * @return the IdDocror
     */
   
    
    
}
