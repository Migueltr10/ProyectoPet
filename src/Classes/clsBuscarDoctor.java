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
public class clsBuscarDoctor {
    private int idhosp;
    private String nomhops;
    private String numhosp;
    private int iddoctor;
    private String nombredoc;
    private String address;
    private String phone;
    private String documento;

    public clsBuscarDoctor(int idhosp, String nomhops, String numhosp, int iddoctor, String nombredoc, String address, String phone, String documento) {
        this.idhosp = idhosp;
        this.nomhops = nomhops;
        this.numhosp = numhosp;
        this.iddoctor = iddoctor;
        this.nombredoc = nombredoc;
        this.address = address;
        this.phone = phone;
        this.documento = documento;
    }

   

    

    
    /**
     * @return the idhosp
     */
   

    /**
     * @return the nomhops
     */
    public String getNomhops() {
        return nomhops;
    }

    /**
     * @param nomhops the nomhops to set
     */
    public void setNomhops(String nomhops) {
        this.nomhops = nomhops;
    }

    /**
     * @return the numhosp
     */
    public String getNumhosp() {
        return numhosp;
    }

    /**
     * @param numhosp the numhosp to set
     */
    public void setNumhosp(String numhosp) {
        this.numhosp = numhosp;
    }

    /**
     * @return the iddoctor
     */
    public int getIddoctor() {
        return iddoctor;
    }

    /**
     * @param iddoctor the iddoctor to set
     */
    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    /**
     * @return the nombredoc
     */
    public String getNombredoc() {
        return nombredoc;
    }

    /**
     * @param nombredoc the nombredoc to set
     */
    public void setNombredoc(String nombredoc) {
        this.nombredoc = nombredoc;
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
     * @return the idhosp
     */
    public int getIdhosp() {
        return idhosp;
    }

    /**
     * @param idhosp the idhosp to set
     */
    public void setIdhosp(int idhosp) {
        this.idhosp = idhosp;
    }
   
}
