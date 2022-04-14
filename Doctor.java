import java.util.*;

public class Doctor 
{
    String name;             // the name of the doctor.
    String specialisation;   // the specialisation of the doctor.
    
    // code to store the name and specialisation data of the doctors
    public void setData(String name, String specialisation)
    {
        name = name;
        specialisation = specialisation;
    }
    // code to retrieve the name and specialisation data of the doctors
    public String getName()
    {
        return name;
    }
    public String getSpecialisation()
    {
        return specialisation;
    }
}