//  Name: Ethan Davey
//  Student #: c3374491
//  Due Date: 30/04/2018
//  Description: This program emulates a vet clinic in a highly simplified way. 
//  The user can create new doctors and pets, delete pets and doctors within the system, assign pets to doctors, analyse pets weights and produce lists of doctors and pets.

import java.util.*;

public class Clinic 
{ 
    private Doctor doctor1, doctor2 = null;         // create and initialise variables doctor1 & doctor2 with null.
    private Pet pet1, pet2, pet3, pet4 = null;      // create and initialise variables pet1, pet2, pet3 & pet4 with null.
    Scanner console = new Scanner(System.in);       // create scanner with name 'console' to read/ write to the console.
    String choice;                                  // create string variable with name 'choice' to be used for the menu and a yes/ no choice in 'assignDoctor()' method.
    
    Doctor d = new Doctor();                        // create a new Doctor with name 'd' to be used to hold temporary values such as name and specialisation.
    Pet p = new Pet();                              // create a new Pet with name 'p' to be used to hold temporary values such as name and type.
    
    // method to call the menu & keep the program running.
    private void run()  
    {
        // the following 4 lines are to print the menu and main header while aiding with the formatting of the menu.
        System.out.println("************* WELCOME TO THE CLINIC! *************");
        System.out.println();
        System.out.println("********************** MENU **********************");
        System.out.println("(0)exit \r\n(1)add doctor \r\n(2)add pet \r\n(3)delete doctor \r\n(4)delete pet \r\n(5)list of doctors \r\n(6)list of pets \r\n(7)list of pets assigned to specific doctor \r\n(8)assign doctor to pet \r\n(9)analyse pet");
        choice = console.next();
        // while statement calls the menu after each decision, except when 0 is chosen where the program exits.
        while(!choice.equals("0")){
            switch(choice) {
                case("1"):
                    addDoctor();            // calls the 'addDoctor()' method. allows the user to create a new doctor within the system.
                    break;
                    
                case("2"):
                    addPet();               // calls the 'addPet()' method. allows the user to create a new pet within the system.
                    break;
                    
                case("3"):
                    deleteDoctor();         // calls the 'deleteDoctor()' method. allows the user to delete a doctor from the system.
                    break;
                    
                case("4"):
                    deletePet();            // calls the 'deletePet()' method. allows the user to delete a pet from the system.
                    break;
                    
                case("5"):
                    listDoctors();          // calls the 'listDoctors()' method. displays a list of the doctors currently in the system.
                    break;
                    
                case("6"):
                    listPets();             // calls the 'listPets()' method. displays a list of the pets currently in the system.
                    break;
                    
                case("7"):
                    listPetsOfDoctor();     // calls the 'listPetsOfDoctor()' method. displays a list of the pets assigned to a specific doctor.
                    break;
                    
                case("8"):
                    assignDoctor();         // calls the 'assignDoctor()' method. allows the user to assign a pet to a doctor.
                    break;
                    
                case("9"):
                    analysePet();           // calls the 'analysePet()' method. analyses a pet and displays a message telling the user if the pet is overweight or not.
                    break;
                    
                default:
                    break;                  // re-enters the loop if 1,2,3,4,5,6,7,8,9 or 0 is not entered.  
                    
            } 
            System.out.println();
            System.out.println("********************** MENU **********************");
            System.out.println("(0)exit \r\n(1)add doctor \r\n(2)add pet \r\n(3)delete doctor \r\n(4)delete pet \r\n(5)list of doctors \r\n(6)list of pets \r\n(7)list of pets assigned to specific doctor \r\n(8)assign doctor to pet \r\n(9)analyse pet");
            choice = console.next();
        }
    }
        
    // creates the method allowing the user to input a doctor into the system.
    public void addDoctor()
    {
        System.out.println("**************************************************");
        System.out.println();
        // asks the user for the doctors name.
        System.out.print("Doctors Name: ");
        d.name = console.next();
        console.nextLine();
        // asks the user for the doctors specialisation.
        System.out.print("Doctors Specialisation (dog or cat): ");        
        d.specialisation = console.nextLine();
        
        // checks whether the user inputed specialisation matches either "cat" or "dog". if it does not match then a message is displayed to the user.
        if(!d.specialisation.equals("cat") && !d.specialisation.equals("dog"))
        {
            System.out.println("Unknown specialisation.");
        }
        // checks if there is an open slot to create a new doctor. if there is not a message is displayed to the user.
        else if (doctor1 != null && doctor2 != null) 
        { 
            System.out.println("Maximum number of doctors have been created.");
        }
        else
        {
            if (doctor1 == null)
            {
                // checks if there is a doctor with the same name. if there is a message is displayed to the user.
                if (doctor2 != null && d.name.equals(doctor2.getName()))
                {
                    System.out.println("A doctor with this name already exists.");
                }
                else
                {
                    // creates a new Doctor named 'doctor1' and assigns the name and specialisation inputed to the Doctor.
                    doctor1 = new Doctor();
                    doctor1.setData(d.name.toLowerCase(), d.specialisation.toLowerCase());
                    System.out.println("Doctor " + doctor1.getName() + ": " + doctor1.getSpecialisation() + " specialisation.");
                }
            }
            else
            {
                // checks if there is a doctor with the same name. if there is a message is displayed to the user.
                if (doctor1 != null && d.name.equals(doctor1.getName()))
                {
                    System.out.println("A doctor with this name already exists.");
                }
                else
                {
                    // creates a new Doctor named 'doctor2' and assigns the name and specialisation inputed to the Doctor.
                    doctor2 = new Doctor();
                    doctor2.setData(d.name.toLowerCase(), d.specialisation.toLowerCase());
                    System.out.println("Doctor " + doctor2.getName() + ": " + doctor2.getSpecialisation() + " specialisation.");
                }
            }
        }
    }
    
    // creates the method allowing the user to input a doctor into the system.
    private void addPet()
    {
        System.out.println("**************************************************");
        System.out.println();
        // asks the user for the pets name.
        System.out.print("Pet Name: ");
        p.name = console.next();
        console.nextLine();
        // asks the user for the cats type.
        System.out.print("Pet Type (dog or cat): ");        
        p.type = console.nextLine();
        // asks the user for the pets size.
        System.out.print("Pet Size (small, medium or large): ");        
        p.size = console.nextLine();
        // asks the user for the pets weight.
        System.out.print("Pet Weight: ");        
        p.weight = console.nextDouble();
        // asks the user for the pets age.
        System.out.print("Pet Age: ");        
        p.age = console.nextInt();
                  
        // checks whether the user inputed type matches either "cat" or "dog". if it does not match then a message is displayed to the user.
        if(!p.type.equals("cat") && !p.type.equals("dog"))
        {
            System.out.println("Unknown type of pet.");
        }
        // checks whether the user inputed size matches either "small", "medium" or "large". if it does not match then a message is displayed to the user.
        else if(!p.size.equals("small") && !p.size.equals("medium") && !p.size.equals("large"))
        {
            System.out.println("Unknown size of pet.");
        }
        // checks whether the user inputed age is positive. if it does not match then a message is displayed to the user.
        else if(p.age <= 0)
        {
            System.out.println("Age must be positive.");
        }
        // checks whether the user inputed weight is positive. if it does not match then a message is displayed to the user.
        else if(p.weight <= 0)
        {
            System.out.println("Weight must be positive.");
        }
        // checks if there is an open slot to create a new pet. if there is not a message is displayed to the user.
        else if (pet1 != null && pet2 != null && pet3 != null && pet4 != null)
        { 
            System.out.println("Maximum number of pets have been created.");
        }
        else
        {
            // checks if all of the pet slots are open.
            if (pet1 == null && pet2 == null && pet3 == null && pet4 == null)
            {
                // creates a new Pet named 'pet1' and assigns the name and specialisation inputed to the Pet.
                pet1 = new Pet();
                pet1.setData(p.type.toLowerCase(), p.size.toLowerCase(), p.weight, p.name.toLowerCase(), p.age);
                System.out.println("Pet successfully added, " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " years old (" + pet1.getDoctor() + ")");
            }
            else if(pet2 == null && pet3 == null && pet4 == null)
            {
                // checks if there is a pet with the same name. if there is a message is displayed to the user.
                if (p.name.equals(pet1.getName()))
                {
                    System.out.println("A pet with this name already exists.");
                }
                else{
                    // creates a new Pet named 'pet2' and assigns the name and specialisation inputed to the Pet.
                    pet2 = new Pet();
                    pet2.setData(p.type.toLowerCase(), p.size.toLowerCase(), p.weight, p.name.toLowerCase(), p.age);
                    System.out.println("Pet successfully added, " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " years old (" + pet2.getDoctor() + ")");
                }
            }
            else if (pet3 == null && pet4 == null)
            {
                // checks if there is a pet with the same name. if there is a message is displayed to the user.
                if (p.name.equals(pet1.getName()) || p.name.equals(pet2.getName()))
                {
                    System.out.println("A pet with this name already exists.");
                }
                else
                {
                    // creates a new Pet named 'pet3' and assigns the name and specialisation inputed to the Pet.
                    pet3 = new Pet();
                    pet3.setData(p.type.toLowerCase(), p.size.toLowerCase(), p.weight, p.name.toLowerCase(), p.age);
                    System.out.println("Pet successfully added, " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " years old (" + pet3.getDoctor() + ")");
                }
            }
            else
            {
                // checks if there is a pet with the same name. if there is a message is displayed to the user.
                if (p.name.equals(pet1.getName()) || p.name.equals(pet2.getName()) || p.name.equals(pet3.getName()))
                {
                    System.out.println("A pet with this name already exists.");
                }
                else
                {
                    // creates a new Pet named 'pet4' and assigns the name and specialisation inputed to the Pet.
                    pet4 = new Pet();
                    pet4.setData(p.type.toLowerCase(), p.size.toLowerCase(), p.weight, p.name.toLowerCase(), p.age);
                    System.out.println("Pet successfully added, " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " years old (" + pet4.getDoctor() + ")");
                }
            }
        }
    }
    
    // creates the method allowing the user to delete a doctor into the system.
    private void deleteDoctor()
    {
        System.out.println("**************************************************");
        System.out.println();
        // asks for the doctors name.
        System.out.println("Which Doctor Would You Like to Delete?");
        System.out.print("Doctors Name: ");
        d.name = console.next();
        console.nextLine();
        

        // checks if a doctor exists in the system. if no doctors exist a message is displayed to the user.
        if(doctor1 == null && doctor2 == null)
        {
            System.out.println("No doctors exist.");
        }
        else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName())) // checks if doctor2 exists and if the name inputed in the same as the name assigned to doctor2. 
        {
            if(pet1 == null)
            {
                doctor2 = null;
            }
            else if(pet1 != null && pet1.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet1 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
            {
                pet1.setDoctor("No doctor assigned");
                if(pet2 != null && pet2.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet2 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                {
                    pet2.setDoctor("No doctor assigned");
                    if(pet3 != null && pet3.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet3.setDoctor("No doctor assigned");
                        if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                        {
                            pet4.setDoctor("No doctor assigned");
                        }    
                        else{}
                    }
                    else if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("No doctor assigned");
                    }
                    else{}
                } 
                else if(pet3 != null && pet3.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                {
                    pet3.setDoctor("No doctor assigned");
                    if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("No doctor assigned"); // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                    }
                    else{}
                }
                else if(pet4 != null && pet4.getDoctor().equals(doctor2.getName()))
                {
                    pet4.setDoctor("No doctor assigned"); // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                }
                else{}
            }
            else if(pet2 != null && pet2.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet2 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
            {
                pet2.setDoctor("No doctor assigned");
                if(pet3 != null && pet3.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                {
                    pet3.setDoctor("No doctor assigned");
                    if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("No doctor assigned");
                    }
                    else{}
                }
                else if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                {
                    pet4.setDoctor("No doctor assigned"); 
                }
                else{}
            }
            else if(pet3 != null && pet3.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
            {
                pet3.setDoctor("No doctor assigned");
                if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
                {
                    pet4.setDoctor("No doctor assigned");
                }
                else{}
            }
            else if(pet4 != null && pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor2 and updates the assigned doctor to "No doctor assigned".
            {
                pet4.setDoctor("No doctor assigned");
            }
            else{}
            doctor2 = null; // assigning doctor2 as null removes all data from the variable, essentially deleteing it from the system.
            System.out.println("Doctor successfully removed."); // displays a message to the user telling them the deletion was successfull.
        }
        else if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if doctor1 exists and if the name inputed in the same as the name assigned to doctor1.
        {
            if(pet1 == null)
            {
                doctor1 = null;
            }
            else if(pet1 != null && pet1.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet1 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
            {
                pet1.setDoctor("No doctor assigned");
                if(pet2 != null && pet2.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet2 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet2.setDoctor("No doctor assigned");
                    if(pet3 != null && pet3.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet3.setDoctor("No doctor assigned");
                        if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                        {
                            pet4.setDoctor("No doctor assigned");
                        }    
                        else{}
                    }
                    else if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("No doctor assigned");
                    }
                    else{}
                }
                else if(pet3 != null && pet3.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet3.setDoctor("No doctor assigned");
                    if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("no doctor assigned");
                    }
                    else{}
                }
                else if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet4.setDoctor("No doctor assigned");
                }
                else{}
            }
            else if(pet2 != null && pet2.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet2 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
            {
                pet2.setDoctor("No doctor assigned");
                if(pet2 != null && pet3.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet3.setDoctor("No doctor assigned");
                    if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                    {
                        pet4.setDoctor("No doctor assigned");
                    }
                    else{}
                }
                else if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet4.setDoctor("No doctor assigned");
                }
                else{}
            }
            else if(pet3 != null && pet3.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet3 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
            {
                pet3.setDoctor("No doctor assigned");
                if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
                {
                    pet4.setDoctor("No doctor assigned");
                }
                else{}
            }
            else if(pet4 != null && pet4.getDoctor().equals(doctor1.getName())) // checks if the doctor assigned to pet4 is the same as the name of doctor1 and updates the assigned doctor to "No doctor assigned".
            {
                pet4.setDoctor("No doctor assigned");
            }
            else{}
            doctor1 = null; // assigning doctor1 as null removes all data from the variable, essentially deleteing it from the system.
            System.out.println("Doctor successfully removed."); // displays a message to the user telling them the deletion was successful.
        }
        else 
        {
            System.out.println("No doctor with this name."); // if the name did not match with either doctors stored name this message is displayed to the user.
        }
    }
    
    private void deletePet()
    {
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Which Pet Would You Like to Delete?");
        // asks the user for the pets name.
        System.out.print("Pet Name: ");
        p.name = console.next();
        console.nextLine();
        
        if(pet4 != null) // checks if all pet slots are filled.
        {
            if(p.name.toLowerCase().equals(pet1.getName())) // checks if the user inputed name matches the stored name for pet1.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet1 = pet2;
                pet2 = pet3;
                pet3 = pet4;                
                pet4 = null; // assigns pet4 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet2.getName())) // checks if the user inputed name matches the stored name for pet2.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet2 = pet3;
                pet3 = pet4;                
                pet4 = null; // assigns pet4 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet3.getName())) // checks if the user inputed name matches the stored name for pet3.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet3 = pet4;
                pet4 = null; // assigns pet4 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet4.getName())) // checks if the user inputed name matches the stored name for pet4.
            {
                pet4 = null; // assigns pet4 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else 
            {
                System.out.println("No pet with this name."); // if the user inputed name does not match any pet name this message is displayed to the user.
            }
        }
        else if(pet3 != null)
        {
            if(p.name.toLowerCase().equals(pet1.getName())) // checks if the user inputed name matches the stored name for pet1.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet1 = pet2;
                pet2 = pet3;
                pet3 = null; // assigns pet3 as null, removing all stored data from the pet.           
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet2.getName())) // checks if the user inputed name matches the stored name for pet2.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet2 = pet3;
                pet3 = null; // assigns pet3 as null, removing all stored data from the pet.              
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet3.getName())) // checks if the user inputed name matches the stored name for pet3.
            {
                pet3 = null; // assigns pet3 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else 
            {
                System.out.println("No pet with this name."); // if the user inputed name does not match any pet name this message is displayed to the user.
            }
        }
        else if(pet2 != null)
        {
            if(p.name.toLowerCase().equals(pet1.getName())) // checks if the user inputed name matches the stored name for pet1.
            {
                //reassigns the data from the pet variables moving them one space down. (pet2 becomes pet1, pet3 becomes pet2 etc).
                pet1 = pet2;
                pet2 = null; // assigns pet2 as null, removing all stored data from the pet.            
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else if(p.name.toLowerCase().equals(pet2.getName())) // checks if the user inputed name matches the stored name for pet2.
            {
                pet2 = null; // assigns pet2 as null, removing all stored data from the pet.
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else 
            {
                System.out.println("No pet with this name."); // if the user inputed name does not match any pet name this message is displayed to the user.
            }
        }
        else if(pet1 != null)
        {
            if(p.name.toLowerCase().equals(pet1.getName())) // checks if the user inputed name matches the stored name for pet1.
            {
                pet1 = null; // assigns pet1 as null, removing all stored data from the pet.      
                System.out.println("Pet successfully removed."); // displays a message telling the user the deletion was successful.
            }
            else 
            {
                System.out.println("No pet with this name."); // if the user inputed name does not match any pet name this message is displayed to the user.
            }
        }
        else
        {
            System.out.println("No pets."); // if no pets exist this message is displayed to the user.
        }
    }
    
    // creates the method allowing the user to see a list of the doctors whithin the system.
    private void listDoctors()
    {
        System.out.println("**************************************************");
        System.out.println();
        
        if (doctor1 != null)
        {
            if(doctor2 == null)
            {
                System.out.println("Doctor " + doctor1.getName() + ": " + doctor1.getSpecialisation() + " specialisation."); // only displays this message if doctor1 is the only doctor in the system
            }
            else
            {
                System.out.println("Doctor " + doctor1.getName() + ": " + doctor1.getSpecialisation() + " specialisation.");
                System.out.println("Doctor " + doctor2.getName() + ": " + doctor2.getSpecialisation() + " specialisation."); // only displays this message if both doctor1 and doctor2 exist in the system.
            }
        }
        else if (doctor2 != null)
        {
            System.out.println("Doctor " + doctor2.getName() + ": " + doctor2.getSpecialisation() + " specialisation."); // only displays this message if doctor2 is the only doctor in the system
        }
        else
        {
            System.out.println("No doctors."); // this message is displayed if there are no doctors within the system.
        }
    }
    
    // creates the method allowing the user to see a list of the pets within the system.
    private void listPets()
    {
        System.out.println("**************************************************");
        System.out.println();
        if(pet1 == null && pet2 == null && pet3 == null && pet4 == null) // checks if any pets exist.
        {
            System.out.println("No pets."); // this message is displayed if there are no pets in the system.
        }
        else
        {
            if(pet2 == null) // checks if pet2 exists. if pet2 does not exist the following message is displayed.
            {
                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
            }
            else if(pet3 == null) // checks if pet3 exists. if pet3 does not exist the following messages are displayed.
            {
                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " years old (" + pet2.getDoctor() + ")");
            }
            else if(pet4 == null) // checks if pet4 exists. if pet4 does not exist the following messages are displayed.
            {
                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
            }
            else // the following messages are only displayed if all 4 pets exist in the system.
            {
                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
            }
        }
    }
    

    // creates the method that allows the user to see a list of the pets assigned to a specific doctor.
    private void listPetsOfDoctor()
    {
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Which doctors pets would you like to see?");
        // asks the user for the doctors name.
        System.out.println("Doctor Name: ");
        d.name = console.next();
        console.nextLine();

        if(pet1 == null && pet2 == null && pet3 == null && pet4 == null) // checks if any pets exist in the system.
        {
            System.out.println("No pets."); // this message is displayed if no pets exist in the system.
        }
        else if(doctor1 == null && doctor2 == null) // checks if any doctors exist in the system.
        {
            System.out.println("No doctors."); // this message is displayed if no doctors exist in the system.
        }
        else
        {
            if(pet4 != null) // checks if all 4 pet slots are full
            {
                if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if the user inputed name is the same as the name stored for doctor1.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                            {
                                if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                                {
                                    System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                    System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                    System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                    System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                                }
                                else
                                {
                                    System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                    System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                    System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                }
                            }
                            else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            }
                        }
                        else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                        }
                        else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                        }
                        else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                    }
                    else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                    {
                        if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                    }
                    else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName()))  // checks if the user inputed name is the same as the name stored for doctor2.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                            {
                                if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                                {
                                    System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                    System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                    System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                    System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                                }
                                else
                                {
                                    System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                    System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                    System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                }
                            }
                            else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            }
                        }
                        else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                        }
                        else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                                System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                        }
                        else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                    }
                    else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                    {
                        if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                    }
                    else if(pet4.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet4 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet4.getName() + ": " + pet4.getSize() + " " + pet4.getType() + " weighing " + pet4.getWeight() + "kg at " + pet4.getAge() + " year(s) old (" + pet4.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else
                {
                    System.out.println("No doctor with that name."); // messaged is displayed if the user inputed name does not match any of the stored doctor names.
                }
            }
            else if(pet3 != null) // checks if 3 pet slots are full
            {
                if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if the user inputed name is the same as the name stored for doctor1.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            }
                        }
                        else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                    }
                    else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName())) // checks if the user inputed name is the same as the name stored for doctor2.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                                System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                            }
                            else
                            {
                                System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                                System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            }
                        }
                        else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                            System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                    }
                    else if(pet3.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet3 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet3.getName() + ": " + pet3.getSize() + " " + pet3.getType() + " weighing " + pet3.getWeight() + "kg at " + pet3.getAge() + " year(s) old (" + pet3.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else
                {
                    System.out.println("No doctor with that name."); // messaged is displayed if the user inputed name does not match any of the stored doctor names.
                }
            }
            else if(pet2 != null) // checks if 2 pet slots are full
            {
                if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if the user inputed name is the same as the name stored for doctor1.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase()))  // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName())) // checks if the user inputed name is the same as the name stored for doctor2.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase()))  // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        if(pet2.getDoctor().equals(d.name.toLowerCase()))  // checks if the doctor for pet2 is the same as the user inputed name.
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                            System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                        }
                        else
                        {
                            System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                        }
                    }
                    else if(pet2.getDoctor().equals(d.name.toLowerCase()))  // checks if the doctor for pet2 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet2.getName() + ": " + pet2.getSize() + " " + pet2.getType() + " weighing " + pet2.getWeight() + "kg at " + pet2.getAge() + " year(s) old (" + pet2.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else
                {
                    System.out.println("No doctor with that name."); // messaged is displayed if the user inputed name does not match any of the stored doctor names.
                }
            }
            else if(pet1 != null) // checks if 1 pet slot is full
            {
                if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if the user inputed name is the same as the name stored for doctor1.
                {
                    if(pet1.getDoctor().equals(d.name.toLowerCase())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName())) // checks if the user inputed name is the same as the name stored for doctor2.
                {
                    if(pet1.getDoctor().equals(doctor2.getName())) // checks if the doctor for pet1 is the same as the user inputed name.
                    {
                        System.out.println("Pet " + pet1.getName() + ": " + pet1.getSize() + " " + pet1.getType() + " weighing " + pet1.getWeight() + "kg at " + pet1.getAge() + " year(s) old (" + pet1.getDoctor() + ")");
                    }
                    else
                    {
                        System.out.println("No assigned pets."); // message is displayed if the doctor has no assigned pets.
                    }
                }
                else
                {
                    System.out.println("No doctor with that name."); // messaged is displayed if the user inputed name does not match any of the stored doctor names.
                }
            }
        }
    }
    
    // creates the method to allow the user to assign a doctor to a pet.
    private void assignDoctor()
    {
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Which Pet Would You Like to Assign?");
        // asks the user for the pets name.
        System.out.print("Pet Name: ");
        p.name = console.next();
        console.nextLine();
        System.out.println("Which Doctor Would You Like to Assign?");
        // asks the user for the doctors name.
        System.out.print("Doctor Name: ");
        d.name = console.next();
        console.nextLine();
        
        // checks if a pet exists in the system.
        if(pet1 == null && pet2 == null && pet3 == null && pet4 == null)
        {
            System.out.println("No pets."); // message is displayed if no pets exist.
        }
        // checks if a doctor exists in the system.
        else if(doctor1 == null && doctor2 == null )
        {
            System.out.println("No doctors."); // message is displayed if no pets exist.
        }
        else
        {
            if(doctor1 != null && d.name.toLowerCase().equals(doctor1.getName())) // checks if doctor1 exists and the user inputed name matches the stored name for doctor1.
            {
                if(pet1 != null && p.name.toLowerCase().equals(pet1.getName())) // checks if pet1 exists and the user inputed name matches the stored name for pet1.
                {
                    if(!pet1.getType().equals(doctor1.getSpecialisation())) // checks if the specialisation of the doctor is the same as the type of the pet.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet1.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet1.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet1.getDoctor().equals(doctor1.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.toLowerCase().equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet1.setDoctor(doctor1.getName());
                                System.out.println(pet1.getDoctor() + " assigned to " + pet1.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet1.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else // if no doctor was previously assigned the following code is run.
                    {
                        pet1.setDoctor(doctor1.getName()); // the new doctor is assigned.
                        System.out.println(pet1.getDoctor() + " assigned to " + pet1.getName()); // message displayed to show the user the assignment fo the doctor has worked.
                    }
                }
                else if(pet2 != null && p.name.toLowerCase().equals(pet2.getName())) // checks if pet2 exists and the user inputed name matches the stored name for pet2.
                {
                    if(!pet2.getType().equals(doctor1.getSpecialisation())) // checks if the specialisation of the doctor is the same as the type of the pet.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet2.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet2.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet2.getDoctor().equals(doctor1.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? ");// asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet2.setDoctor(doctor1.getName());
                                System.out.println(pet2.getDoctor() + " assigned to " + pet2.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet2.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet2.setDoctor(doctor1.getName()); // the new doctor is assigned.
                        System.out.println(pet2.getDoctor() + " assigned to " + pet2.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else if(pet3 != null && p.name.toLowerCase().equals(pet3.getName())) // checks if pet3 exists and the user inputed name matches the stored name for pet3.
                {
                    if(!pet3.getType().equals(doctor1.getSpecialisation())) // checks if the specialisation of the doctor is the same as the type of the pet.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet3.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet3.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet3.getDoctor().equals(doctor1.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet3.setDoctor(doctor1.getName()); 
                                System.out.println(pet3.getDoctor() + " assigned to " + pet3.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet3.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet3.setDoctor(doctor1.getName()); // new doctor is assigned.
                        System.out.println(pet3.getDoctor() + " assigned to " + pet3.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else if(pet4 != null && p.name.toLowerCase().equals(pet4.getName())) // checks if pet4 exists and the user inputed name matches the stored name for pet4.
                {
                    if(!pet4.getType().equals(doctor1.getSpecialisation())) // checks if the specialisation of the doctor is the same as the type of the pet.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet4.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet4.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet1.getDoctor().equals(doctor1.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet4.setDoctor(doctor1.getName());
                                System.out.println(pet4.getDoctor() + " assigned to " + pet4.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet4.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet4.setDoctor(doctor1.getName()); // the new doctor is assigned.
                        System.out.println(pet4.getDoctor() + " assigned to " + pet4.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else
                {
                    System.out.println("No pet with that name."); // messsage displayed if no pet matches that name.
                }
            }
            else if(doctor2 != null && d.name.toLowerCase().equals(doctor2.getName())) // checks if doctor2 exists and the user inputed name matches the stored name for doctor2.
            {
                if(pet1 != null && p.name.toLowerCase().equals(pet1.getName())) // checks if pet1 exists and the user inputed name matches the stored name for pet1.
                {
                    if(!pet1.getType().equals(doctor2.getSpecialisation())) // message displayed if the doctor has a different specialisation.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet1.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet1.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet1.getDoctor().equals(doctor2.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet1.setDoctor(doctor2.getName());
                                System.out.println(pet1.getDoctor() + " assigned to " + pet1.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet1.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet1.setDoctor(doctor2.getName()); // the new doctor is assigned.
                        System.out.println(pet1.getDoctor() + " assigned to " + pet1.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else if(pet2 != null && p.name.toLowerCase().equals(pet2.getName())) // checks if pet2 exists and the user inputed name matches the stored name for pet2.
                {
                    if(!pet2.getType().equals(doctor2.getSpecialisation())) // message displayed if the doctor has a different specialisation.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet1.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet2.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet2.getDoctor().equals(doctor2.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet2.setDoctor(doctor2.getName());
                                System.out.println(pet2.getDoctor() + " assigned to " + pet2.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet2.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet2.setDoctor(doctor2.getName()); // the new doctor is assigned.
                        System.out.println(pet2.getDoctor() + " assigned to " + pet2.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else if(pet3 != null && p.name.toLowerCase().equals(pet3.getName())) // checks if pet3 exists and the user inputed name matches the stored name for pet3.
                {
                    if(!pet3.getType().equals(doctor2.getSpecialisation())) // message displayed if the doctor has a different specialisation.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet1.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet3.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet3.getDoctor().equals(doctor2.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet3.setDoctor(doctor2.getName());
                                System.out.println(pet3.getDoctor() + " assigned to " + pet3.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet3.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet3.setDoctor(doctor2.getName()); // the new doctor is assigned.
                        System.out.println(pet3.getDoctor() + " assigned to " + pet3.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
                else if(pet4 != null && p.name.toLowerCase().equals(pet4.getName())) // checks if pet4 exists and the user inputed name matches the stored name for pet4.
                {
                    if(!pet4.getType().equals(doctor2.getSpecialisation())) // message displayed if the doctor has a different specialisation.
                    {
                        System.out.println("This doctor cannot be assigned to " + pet1.getType() + "s."); // message displayed if the doctor has a different specialisation.
                    }
                    else if(!pet4.getDoctor().equals("No doctor assigned")) // checks if there is already a doctor assigned to the pet.
                    {
                        if(pet4.getDoctor().equals(doctor2.getName())) // checks if the doctor the user is trying to assign is the same as the doctor currently assigned.
                        {
                            System.out.println("This doctor is already assigned to this pet."); // message displayed if above is true.
                        }
                        else
                        {
                            System.out.print("This pet already has a doctor assigned. Would you like to assign a new doctor? "); // asks the user if they would like to change the doctor assigned to the pet.
                            choice = console.nextLine(); // variable choice can be used here as "yes" does not exit the while loop in the run() method.
                            if(choice.equals("yes")) // checks if the choice is a yes.
                            {
                                // if the choice is yes, the new doctor is assigned.
                                pet4.setDoctor(doctor2.getName());
                                System.out.println(pet4.getDoctor() + " assigned to " + pet4.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                            }
                            else
                            {
                                System.out.println("Doctor assigned to " + pet4.getName() + " has not been updated"); // messaged displayed if the pets doctor is not updated.
                            }
                        }
                    }
                    else
                    {
                        pet4.setDoctor(doctor2.getName()); // the new doctor is assigned.
                        System.out.println(pet4.getDoctor() + " assigned to " + pet4.getName()); // messaged displayed to show the user the assignment of doctor has worked.
                    }
                }
            }
            else
            {
                if(doctor1 != null && !d.name.toLowerCase().equals(doctor1.getName())) // checks if the name matches a current doctor.
                {
                    System.out.println("No doctor with that name."); // message displayed to user.
                }
                else if(pet1 != null && !p.name.toLowerCase().equals(pet1.getName())) // checks if the name matches a current pet.
                {
                    System.out.println("No pet with that name."); // message displayed to user.
                }
            }
        }
    }
    
    private void analysePet()
    {
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Which Pet Would You Like to Analyse?");
        // asks the user for the pet name.
        System.out.print("Pet Name: ");
        p.name = console.next();
        console.nextLine();
        
        // checks if a pet exists in the system.
        if(pet1 == null && pet2 == null && pet3 == null && pet4 == null)
        {
            System.out.println("No pets.");
        }
        // checks if a doctor exists in the system.
        else if(doctor1 == null && doctor2 == null )
        {
            System.out.println("No doctors.");
        }
        else
        {
            if(pet1 != null && p.name.toLowerCase().equals(pet1.getName())) // checks if pet1 exists, and if the name inputed matches the name of pet1.
            {
                if(pet1.getDoctor().equals("No doctor assigned")) // checks if no doctor is assigned to pet.
                {
                    System.out.println("No doctor assigned"); // if no doctor assigned. display this message.
                }
                else if(pet1.getType().equals("cat")) // check if the pet type is "cat".
                {
                    if(pet1.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet1.getWeight() > 4) // checks if the weight is greater then 4.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet1.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet1.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet1.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet1.getWeight() > 8) // checks if the weight is greater then 8.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
                else if(pet1.getType().equals("dog")) // check if the pet type is "dog".
                {
                    if(pet1.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet1.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet1.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet1.getWeight() > 9) // checks if the weight is greater then 9.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet1.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet1.getWeight() > 12) // checks if the weight is greater then 12.
                        {
                            System.out.println("Pet: " + pet1.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet1.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
            }
            else if(pet2 != null && p.name.toLowerCase().equals(pet2.getName())) // checks if pet2 exists, and if the name inputed matches the name of pet2.
            {
                if(pet2.getDoctor().equals("No doctor assigned")) // checks if no doctor is assigned to pet.
                {
                    System.out.println("No doctor assigned"); // if no doctor assigned. display this message.
                }
                else if(pet2.getType().equals("cat")) // check if the pet type is "cat".
                {
                    if(pet2.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet2.getWeight() > 4) // checks if the weight is greater then 4.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet2.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet2.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet2.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet2.getWeight() > 8) // checks if the weight is greater then 8.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
                else if(pet2.getType().equals("dog")) // check if the pet type is "dog".
                {
                    if(pet2.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet2.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet2.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet2.getWeight() > 9) // checks if the weight is greater then 9.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet2.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet2.getWeight() > 12) // checks if the weight is greater then 12.
                        {
                            System.out.println("Pet: " + pet2.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet2.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
            }
            else if(pet3 != null && p.name.toLowerCase().equals(pet3.getName()))  // checks if pet3 exists, and if the name inputed matches the name of pet3.
            {
                if(pet3.getDoctor().equals("No doctor assigned")) // checks if no doctor is assigned to pet.
                {
                    System.out.println("No doctor assigned"); // if no doctor assigned. display this message.
                }
                else if(pet3.getType().equals("cat")) // check if the pet type is "cat".
                {
                    if(pet3.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet3.getWeight() > 4) // checks if the weight is greater then 4.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet3.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet3.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet3.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet3.getWeight() > 8) // checks if the weight is greater then 8.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
                else if(pet3.getType().equals("dog")) // check if the pet type is "dog".
                {
                    if(pet3.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet3.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet3.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet3.getWeight() > 9) // checks if the weight is greater then 9.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet3.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet3.getWeight() > 12) // checks if the weight is greater then 12.
                        {
                            System.out.println("Pet: " + pet3.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet3.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
            }
            else if(pet4 != null && p.name.toLowerCase().equals(pet4.getName())) // checks if pet4 exists, and if the name inputed matches the name of pet4.
            {
                if(pet4.getDoctor().equals("No doctor assigned")) // checks if no doctor is assigned to pet.
                {
                    System.out.println("No doctor assigned"); // if no doctor assigned. display this message.
                }
                else if(pet4.getType().equals("cat")) // check if the pet type is "cat".
                {
                    if(pet4.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet4.getWeight() > 4) // checks if the weight is greater then 4.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet4.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet4.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet4.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet4.getWeight() > 8) // checks if the weight is greater then 8.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
                else if(pet4.getType().equals("dog")) // check if the pet type is "dog".
                {
                    if(pet4.getSize().equals("small")) // check if the pet size is "small".
                    {
                        if(pet4.getWeight() > 6) // checks if the weight is greater then 6.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet4.getSize().equals("medium")) // check if the pet size is "medium".
                    {
                        if(pet4.getWeight() > 9) // checks if the weight is greater then 9.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                    else if(pet4.getSize().equals("large")) // check if the pet size is "large".
                    {
                        if(pet4.getWeight() > 12) // checks if the weight is greater then 12.
                        {
                            System.out.println("Pet: " + pet4.getName() + " is over weight."); // message displayed if pet is overweight.
                        }
                        else 
                        {
                            System.out.println("Pet: " + pet4.getName() + " is not over weight."); // message displayed if pet is not overweight.
                        }
                    }
                }
            }
            else
            {
                System.out.println("No pet with that name."); // message displayed if no pets match that name.  
            }
        }
    }
    
    // the main method of the class, which starts the program.
    public static void main(String[] args)
    {
        Clinic clinic = new Clinic();
        clinic.run(); // calls the run() method which controls the flow of the program.
    }
}