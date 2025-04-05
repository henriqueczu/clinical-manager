import java.util.ArrayList;
import java.util.Scanner;

public class Patient{
    String name;
    int age;
    int id;

    public Patient(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public static ArrayList<Patient> patients = new ArrayList<>();
    public static int nextId = 1;

    public static void createPatient(Scanner sc){
        System.out.println("\n=== Create a new Patient ===");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = sc.nextInt();

        Patient newPatient = new Patient(name, age, nextId++);
        patients.add(newPatient);
    }

    
    public static void listPatient(){
        System.out.println("\n=== List of Patients ===");
        if(patients.isEmpty()){
            System.out.println("Empty...");
            return;
        }
        int i = 1;
        for(Patient patient : patients){
            System.out.println("Patient ["+i+"]");
            System.out.println("Name: "+patient.name+" \nAge: "+patient.age+" \nId: "+patient.id);
            i++;
        }
    }

    public static void deletePatient(Scanner sc){
        int i = 0;
        do { 
            listPatient();

            if(patients.isEmpty()){
                System.out.println("There is nothing here to delete");
                return;
            }
            System.out.println("\nChoose the patient to delete");
            System.out.print("Patient number: ");
            
            if(sc.hasNextInt()){
                i = sc.nextInt();
            }else{
                System.out.println("Please, digit a number");
                sc.next();
                continue;
            }

            if(i <= 0 || i > patients.size()){
                System.out.println("Please, choose a number in the list range");
            }
        } while (i <= 0 || i > patients.size());

        System.out.println("Deleting patient "+i);
        System.out.println(patients.get(i-1));

        patients.remove(i-1);
    }

}