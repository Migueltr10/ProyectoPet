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
public class clsDog extends clsPet{
    private int dogId;
    private boolean pedigree;
    private String breed;

    public clsDog(int dogId, boolean pedigree, String breed, int petId, String name, String code, int born_year, String color, String health_status) {
        super(petId, name, code, born_year, color, health_status);
        this.dogId = dogId;
        this.pedigree = pedigree;
        this.breed = breed;
    }
    
    public void WalkAround(){
        System.out.println("El perro "+super.getName()+" esta paseando.");
    }
    
     public void WalkAround(int km){
        System.out.println("El perro "+super.getName()+" esta paseando "+km);
    }
    
     public void WalkAround(boolean dogLeash){
        String hasLeash = dogLeash ?"con correa":"sin correa";
        System.out.println("El perro "+super.getName()+" esta paseando "+hasLeash);
    }
     
    public void assist(){
        System.out.println("El perro "+super.getName()+" ayuda a su amo.");
    }
    
    @Override
     public void Eat(){
        System.out.println("El perro "+super.getName()+" esta comiendo");
    }
    
    @Override
    public void Move(){
        System.out.println("El perro "+super.getName()+" se esta moviendo");
    }
    
    @Override
    public void Play(){
        System.out.println("El perro "+super.getName()+" esta jugando");
    }
    
    @Override
    public void Sound(){
        System.out.println("El perro "+super.getName()+" esta ladrando");
    }
    
    /**
     * @return the pedigree
     */
    public boolean isPedigree() {
        return pedigree;
    }

    /**
     * @param pedigree the pedigree to set
     */
    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

   
    
    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String getAnimalType() {
        return "Perro";
    }

    @Override
    public int getNumberOfBones() {
        return 320;
    }

    /**
     * @return the dogId
     */
    public int getDogId() {
        return dogId;
    }

    /**
     * @param dogId the dogId to set
     */
    public void setDogId(int dogId) {
        this.dogId = dogId;
    }
    
    
    
}
