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
public class clsCat extends clsPet{
    private int catId;
    private String breed;

    public clsCat(int catId, String breed, int petId, String name, String code, int born_year, String color, String health_status) {
        super(petId, name, code, born_year, color, health_status);
        this.catId = catId;
        this.breed = breed;
    }
    
    @Override
     public void Eat(){
        System.out.println("El gato "+super.getName()+" esta comiendo");
    }
    
    @Override
    public void Move(){
        System.out.println("El gato "+super.getName()+" se esta moviendo");
    }
    
    @Override
    public void Play(){
        System.out.println("El gato "+super.getName()+" esta jugando");
    }
    
    @Override
    public void Sound(){
        System.out.println("El gato "+super.getName()+" hace miaauuu");
    }

     public void Climb() {
        System.out.println("El Gato "+super.getName()+" esta trepando");
    }

    @Override
    public String getAnimalType() {
        return "Gato";
    }

    @Override
    public int getNumberOfBones() {
        return 230;
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

    /**
     * @return the catId
     */
    public int getCatId() {
        return catId;
    }

    /**
     * @param catId the catId to set
     */
    public void setCatId(int catId) {
        this.catId = catId;
    }
    
    
}
