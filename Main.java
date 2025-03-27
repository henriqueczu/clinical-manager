import java.util.Scanner;

public class Main{
    public static void main(String[]args){
        try (Scanner sc = new Scanner(System.in)) {

        int op;
            do { 
                System.out.println("\n#### Clinical Manager Menu ####");
                System.out.println("[1] Register a Doctor");
                System.out.println("[2] List Doctor");
                System.out.println("[3] Register a Patient");
                System.out.println("[4] List Patient");
                System.out.println("[5] New Appointment");
                System.out.println("[6] List Schedule");
                System.out.println("[7] Sair\n");
                System.out.print("Option: ");
                System.out.println("");
                op = sc.nextInt();
                sc.nextLine();
                
                switch(op){
                    case 1 -> Doctor.createDoctor(sc);
                    case 2 -> Doctor.listDoctor();
                    case 3 -> Patient.createPatient(sc);
                    case 4 -> Patient.listPatient();
                    case 5 -> Appointment.createAppointment(sc);
                    case 6 -> Appointment.listAppointment();
                }

            } while (op != 7);

            sc.close();
        }
    }
}


