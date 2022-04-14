*Can't remember the result for this assignment, however, I did receive a HD for this course.*
# SENG1110-Assign2
Assignment 2: Vet Clinic Management Part 2 [Java] 
<nl>
<nl>
## INCLUDED FILES
 - Clinic.java
 - Doctor.java
 - Pet.java

## INTRODUCTION
The objective of this assignment is to extend the implementation of Assignment 1 using <ins>**arrays**</ins> and <ins>**external files**</ins>.

## PROBLEM DESCRIPTION
Your task in this assignment is to extend your vet clinic management program from Assignment 1, by <ins>**adding**</ins> the following functionality:
1. The user may **input up to 4 doctors and 5 pets**.
2. The user may **edit the information of a pet**. The user will input the name of a pet, an attribute to change, and a new attribute value.
If the pet does not exist, or the attribute is invalid, the program should output an error message. The user should be able to change any attribute of a pet except its name and doctor (so, “type”, “size”, “weight”, and “age”). The usual validity checks need to be made on the attribute value (such as whether a new weight is positive).
3. The user may **read in doctors and pets from a file**. The user will input the name of the file to read from. 
	An example file VetManagement.txt is provided on Blackboard.
	All existing doctors and pets should be deleted before reading from the file. And the file’s specified doctors and pets can be assumed to be valid.
4. The user may **save doctors and pets to a file**. The user will input the name of the file to write to. The output file should have the same format as that expected when reading from a file.

The functionalities from Assignment 1 should remain, but must be adapted to use doctor and pet arrays. They are listed again below.

 1. The user may enter a new doctor into the vet clinic. The user will input the name and specialisation. If a doctor with the same name already exists, or the specialisation is invalid, or the doctor limit has been reached, the program should output an error message.
2. The user may enter a new pet into the vet clinic. The user will input the name, type, size, weight, and age. If a pet with the same name already exists, or an invalid value is given, or the pet limit has been reached, the program should output an error message.
3. The user may delete a doctor from the vet clinic. The user will input the name of the doctor. If the doctor does not exist, the program should output an error message. Before deletion, all pets that are assigned to the specified doctor should have their 'doctor' instance variable updated to "No doctor assigned".
4. The user may delete a pet from the vet clinic. The user will input the name of the pet. If the pet does not exist, the program should output an error message.
5. The user may request a list of doctors in the vet clinic with all the information of each doctor. Normally, one line should be output for each doctor, with the form: Doctor *NAME*: *SPECIALISATION* specialist. If there are no doctors, the program should output the message "No doctors".
6. The user may request a list of pets in the vet clinic with all the information of each pet. Normally, one line should be output for each pet, with the form: "Pet *NAME*: *SIZE* *TYPE* weighing *WEIGHT* kg at *AGE* years old (*DOCTOR*)." If there are no pets, the program should output the message "No pets".
7. The user may request a list of pets assigned to a specific doctor. The user will input the name of the doctor. Normally, one line should be output for each pet, similarly to above. If there are no doctors, the program should
output "No doctors". If the named doctor does not exist, the program should output "No doctor with that name". Otherwise, if the doctor has no assigned pets, the program should output "No assigned pets".
8. The user may assign a doctor to a pet. The user will input the name of the pet and the name of the doctor. If the pet or doctor do not exist, or the pet is already assigned to that doctor, or the doctor does not have the right
specialisation, the program will output an error message. If the pet is already assigned to another doctor, the program should ask the user to confirm that they would like to change the assigned doctor.
9. The user may analyse a pet. The user will input the name of the pet and the program will output an indication of whether the pet is overweight.
##### A cat is considered overweight if it is:
	- Small with weight greater than 4kg
	- Medium with weight greater than 6kg
	- Large with weight greater than 8kg
##### A dog is considered overweight if it is: 
	- Small with weight greater than 6kg
	- Medium with weight greater than 9kg
	- Large with weight greater than 12kg
If the pet does not exist, the program will output an error message.

*Doctor and pet names should be converted to lowercase after input. For example, if the user inputs "Benny", the
program should convert it to "benny".*

## PROGRAM REQUIREMENTS

Your program should consist of three classes, with these names and instance variables (same as Assignment 1, but with doctor and pet arrays):
 - Doctor – stores the following details about a doctor.
	- name – String - the name of the doctor. Should not contain spaces.
	- specialisation – String - the specialisation of the doctor. Must be "dog" or "cat".
- Pet – stores the following details about a pet.
	- name – String – the name of the pet. Should not contain spaces.
	- type – String - the type of the pet. Must be “cat” or “dog”.
	- size – String - the size of the pet. Must be “small”, “medium” or “large”.
	- weight – double - the weight of the pet. Must be positive.
	- age – int - the age of the pet. Must be positive.
	- doctor – String - the doctor of the pet. Should initially be "no doctor assigned".
- Clinic – provides information for all doctors and pets in the clinic.
	- doctors - Doctor[] – an array of Doctor objects. The size should be 4.
	- pets - Pet[] – an array of Pet objects. The size should be 5.

You should continue to apply the principles of encapsulation to your classes, and also have <ins>**two**</ins> constructors in the classes Doctor and Pet. The first constructor should be the default one, i.e., no parameters. The second constructor will have as parameters values for the instance variables.

As before, your classes will need methods to provide the required functionalities. The only class which should have a **main method** is *Clinic.java*, which should create an instance of the class Clinic, and call a method run(), which will display the menu to the user. This class will be the only one that takes input from and sends output to the user. It may do so using either TIO or GUI methods (your choice).
