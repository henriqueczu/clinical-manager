import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Appointment{
    Patient patient;
    Doctor doctor;
    LocalDateTime dateTime;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }

    public static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void createAppointment(Scanner sc){
        if(Patient.patients.isEmpty() || Doctor.doctors.isEmpty()){
            System.out.println("You must have at leat one Patient and one Doctor created");
            return;
        }

        System.out.println("Choose your Doctor");
        for(int i = 0; i < Doctor.doctors.size(); i++){
            System.out.println("["+i+1+"]" +Doctor.doctors.get(i).name);
        }
        System.out.print("\nDoctor number: ");
        int doctorSelected = sc.nextInt();

        sc.nextLine(); 

        System.out.println("Choose your Patient");
        for(int i = 0; i < Patient.patients.size(); i++){
            System.out.println("["+i+1+"]" +Patient.patients.get(i).name);
        }
        System.out.print("\nPatient number: ");
        int patientSelected = sc.nextInt();

        sc.nextLine(); 

        System.out.println("Please, digit the date and hour (Year/Day/Month Hour:Minutes): ");
        String dateTimeInput = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/dd/MM HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, formatter);

        Appointment newAppointment = new Appointment(Patient.patients.get(patientSelected-1), Doctor.doctors.get(doctorSelected-1), dateTime);
        appointments.add(newAppointment);
    }

    
    public static void listAppointment(){
        System.out.println("=== List of Appointments ===");
        if(appointments.isEmpty()){
            System.out.println("Empty...");
            return;
        }

        int i = 1;
        for(Appointment appointment : appointments){
            System.out.println("Appointment ["+i+"]");
            System.out.println("Patient: "+appointment.patient.name+" \nDoctor: "+appointment.doctor.name+" \nDate: " +appointment.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
    }

    public static void deleteAppointment(Scanner sc){
        int i = 0;
        do { 
            listAppointment();

            if(appointments.isEmpty()){
                System.out.println("There is nothing here to delete");
                return;
            }
            System.out.println("\nChoose the appointment to delete");
            System.out.print("Appointment number: ");
            
            if(sc.hasNextInt()){
                i = sc.nextInt();
            }else{
                System.out.println("Please, digit a number");
                sc.next();
                continue;
            }

            if(i <= 0 || i > appointments.size()){
                System.out.println("Please, choose a number in the list range");
            }
        } while (i <= 0 || i > appointments.size());

        System.out.println("Deleting appointment " + i);
        System.out.println(appointments.get(i-1));

        appointments.remove(i-1);
    }
}