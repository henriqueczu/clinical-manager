import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        try (Scanner sc = new Scanner(System.in)) {

        int op;
            do { 
                System.out.println("\n#### Clinical Manager Menu ####");
                System.out.println("[1] Register a Doctor");
                System.out.println("[2] List Doctor");
                System.out.println("[3] Delete Appointment\n");
                System.out.println("[4] Register a Patient");
                System.out.println("[5] List Patient");
                System.out.println("[6] Delete Appointment\n");
                System.out.println("[7] New Appointment");
                System.out.println("[8] Delete Appointment");
                System.out.println("[9] List Schedule\n");
                System.out.println("[10] Sair\n");
                System.out.print("Option: ");
                System.out.println("");
                op = sc.nextInt();
                sc.nextLine();
                
                switch(op){
                    case 1 -> Doctor.createDoctor(sc);
                    case 2 -> Doctor.listDoctor();
                    case 3 -> Doctor.deleteDoctor(sc);
                    case 4 -> Patient.createPatient(sc);
                    case 5 -> Patient.listPatient();
                    case 6 -> Patient.deletePatient(sc);
                    case 7 -> Appointment.createAppointment(sc);
                    case 8 -> Appointment.deleteAppointment(sc);
                    case 9 -> Appointment.listAppointment();
                }

            } while (op != 10);

            sc.close();
        }
    }
}


