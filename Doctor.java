import java.util.ArrayList;
import java.util.Scanner;

public class Doctor{
    String name;
    String speciality;
    int id;

    public Doctor(String name, String speciality, int id) {
        this.name = name;
        this.speciality = speciality;
        this.id = id;
    }

    public static ArrayList<Doctor> doctors = new ArrayList<>();
    public static int nextid = 1;

    public static void createDoctor(Scanner sc){
        System.out.println("\n=== Create a new Doctor ===");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Speciality: ");
        String speciality = sc.nextLine();

        Doctor newDoctor = new Doctor(name, speciality, nextid++);
        doctors.add(newDoctor);
    }

    
    public static void listDoctor(){
        System.out.println("\n=== List of Doctors ===");
        if(doctors.isEmpty()){
            System.out.println("Empty...");
            return;
        }
        
        int i = 1;
        for(Doctor doctor : doctors){
            System.out.println("Doctor ["+i+"]");
            System.out.println("Name: "+doctor.name+" \nSpeciality: "+doctor.speciality+" \nId: "+doctor.id);
            i++;
        }
    }

    public static void deleteDoctor(Scanner sc){
        int i = 0;
        do { 
            listDoctor();

            if(doctors.isEmpty()){
                System.out.println("There is nothing here to delete");
                return;
            }
            System.out.println("\nChoose the doctor to delete");
            System.out.print("Doctor number: ");
            
            if(sc.hasNextInt()){
                i = sc.nextInt();
            }else{
                System.out.println("Please, digit a number");
                sc.next();
                continue;
            }

            if(i <= 0 || i > doctors.size()){
                System.out.println("Please, choose a number in the list range");
            }
        } while (i <= 0 || i > doctors.size());

        System.out.println("Deleting doctor " + i);

        doctors.remove(i-1);
    }
}