import java.util.*;

public class Pet 
{
    
    String type;     // the type of the pet. It can be only cat or dog.
    String size;     // the size of the pet. It can be only small, medium or large.
    String name;     // the name of the pet. 
    double weight;   // the weight of the pet.
    int age;         // the age of the pet.
    String doctor;   // the assigned doctor of the pet.
    
    // code to store the name, type, size, weight and age data of the pets.
    public void setData(String type, String size, double weight, String name, int age){
        this.type = type;
        this.size = size;
        this.weight = weight;
        this.name = name;
        this.age = age;
        this.doctor = "No doctor assigned";
    }
    
    // code to store the assigned doctor of the pets.
    public void setDoctor(String doctor){
        this.doctor = doctor;
    }
    
    // code to retrieve the name, type, size, weight, age and assigned doctor data of the pets.
    public String getType()
    {
        return type;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public double getWeight()
    {
        return weight;
    }
    public String getSize()
    {
        return size;
    }
    public String getDoctor()
    {
        return doctor;
    }
}