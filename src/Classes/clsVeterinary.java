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
public class clsVeterinary {
    private String name;
    private String address;
    private String Nit;
    private String phone;
    private clsDoctor doctor;
    
    
    public clsVeterinary(String name, String address, String Nit, String phone, clsDoctor doctor) {
        this.name = name;
        this.address = address;
        this.Nit = Nit;
        this.phone = phone;
        this.doctor = doctor;
    }
    
    

    public String PetCare(clsPet p){
        System.out.println("atendiendo la mascota "+p.getName());
        return p.getHealth_status();
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
     * @return the Nit
     */
    public String getNit() {
        return Nit;
    }

    /**
     * @param Nit the Nit to set
     */
    public void setNit(String Nit) {
        this.Nit = Nit;
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
     * @return the doctor
     */
    public clsDoctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(clsDoctor doctor) {
        this.doctor = doctor;
    }
    
    
    
}
