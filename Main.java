import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Main Class for Hospital Management Project
public class Main {
    public static void main(String[] args) throws Exception {

        //creation of a hospital object
        Hospital hospital = new Hospital("Shubham Hospital", "Sangli", "12341234", new ArrayList<>(), new ArrayList<>());
        Doctor d1 = new Doctor("Dr. Rao", "Ortho", "1111", "sangli");
        Doctor d2 = new Doctor("Dr. Patil", "Cardio", "2222", "sangli");
        //adding doctors
        hospital.getDoctors().add(d1);
        hospital.getDoctors().add(d2);
        System.out.println("---------------------------------------");
        System.out.println("~ Welcome to the "+hospital.getName()+" ~");
        System.out.println("---------------------------------------");
        //Scanner class object to take user input
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while(choice!=5){
            System.out.println("\n~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~");
            System.out.println("1. Register a new patient");
            System.out.println("2. Book appointment with doctor");
            System.out.println("3. Display patient details");
            System.out.println("4. Display doctor details");
            System.out.println("5. Exit");

            System.out.println("Please enter your choice");
            choice = sc.nextInt();  sc.nextLine(); 

            switch (choice) {
                case 1: //Registration of new patient
                        System.out.println("Enter patient name:");
                        String name = sc.nextLine();

                        while (name.isEmpty()) {
                            System.out.println("Name is required Enter again :");
                            name = sc.nextLine();
                        }
                        System.out.println("Enter patient age:");
                        int age = sc.nextInt();
                        while(age<=0){ //age validation
                            System.out.println("Invalid age Enter Again:");
                            age = sc.nextInt();
                        }
                        System.out.println("Enter patient gender:  (male/female)");
                        String gender = sc.next();
                        while (!"male".equals(gender) && !"female".equals(gender)) { 
                            System.out.println("Invalid gender Enter Again:");
                            gender = sc.next();
                        }
                        System.out.println("Enter patient phone number:");
                        String phone = sc.next();
                        while (phone.length() !=10) { //number validation
                            System.out.println("Invalid number must be 10 digit! Enter again :");
                            phone = sc.next();
                        }
                        sc.nextLine(); //buffer clearing
                        System.out.println("Enter patient address:");
                        String address = sc.nextLine();
                        while (address.isEmpty()) {
                            System.out.println("Address can not be empty !");
                            address = sc.nextLine();
                        }

                        Patient patient = new Patient(name,age,gender,phone,address);
                        hospital.getPatients().add(patient);
                        System.out.println("Patient "+patient.getName()+" registered ! ");
                    break;
                case 2: //Booking of appointment with doctor
                    //First doctor selected from doctor list and then 
                    //from patient list perticular patient is selected for appointment
                    System.out.println("Available doctors :");
                    for(int i=0;i<hospital.getDoctors().size();i++){
                        System.out.println((i+1)+". "+hospital.getDoctors().get(i).getName());
                    }
                    System.out.println("Select doctor using index :");
                    int doctorIndex1 = sc.nextInt() - 1;
                    while (doctorIndex1<0 || doctorIndex1>=hospital.getDoctors().size()) { //validate index
                        System.out.println("Invalid index Enter Again :");
                        doctorIndex1 = sc.nextInt() -1;
                    }
                    Doctor selectedDoctor1 = hospital.getDoctors().get(doctorIndex1); //doctor selection
                    if(hospital.getPatients().isEmpty())
                    {
                        System.out.println("No patients available");
                        Thread.sleep(1000); break;
                    }
                    System.out.println("Select patient using index :");
                    for(int i=0;i<hospital.getPatients().size();i++) {
                        System.out.println((i+1)+". "+hospital.getPatients().get(i).getName());
                    }
                    int patientIndex1 = sc.nextInt()-1;
                    while (patientIndex1<0 || patientIndex1>=hospital.getPatients().size()) { //index validate
                        System.out.println("Invalid index Enter again :");
                        patientIndex1 = sc.nextInt();
                    }
                    sc.nextLine(); //to consume the newline character in previous line
                    Patient selectedPatient1 = hospital.getPatients().get(patientIndex1); //patient selection
                    System.out.println("Enter appointment date and time:");
                    String dateAndTime = sc.nextLine();
                    Appointment appointment = new Appointment(selectedDoctor1, selectedPatient1, dateAndTime);
                    selectedDoctor1.addAppointments(appointment);
                    System.out.println("Appointment booked successfully");
                    System.out.println("Doctor appointed = " +selectedDoctor1.getName());
                    System.out.println("Patient name = "+ selectedPatient1.getName());
                    break;
                case 3: //Display patient details
                    if (hospital.getPatients().isEmpty()) {
                        System.out.println("No patients present...");
                        Thread.sleep(1000); break;
                    }
                    System.out.println("Patients details :");
                    for (int i = 0; i < hospital.getPatients().size(); i++) {
                        System.out.println((i+1)+". "+hospital.getPatients().get(i).getName());
                    }
                    System.out.println("Enter index to get more details :");
                    int patientIndex2 = sc.nextInt() -1;
                    while (patientIndex2<0 || patientIndex2>=hospital.getPatients().size()) { //index validate
                        System.out.println("Invalid index Enter again :");
                        patientIndex2 = sc.nextInt();
                    }
                    Patient selectedPatient2 = hospital.getPatients().get(patientIndex2);
                    System.out.println("Name : " + selectedPatient2.getName());
                    System.out.println("Age : " + selectedPatient2.getAge());
                    System.out.println("Gender : " + selectedPatient2.getGender());
                    System.out.println("Phone : " + selectedPatient2.getPhone());
                    System.out.println("Address : " + selectedPatient2.getAddress());
                    break;
                case 4: //Display doctor details
                    System.out.println("Doctor details : ");
                    for(int i=0; i<hospital.getDoctors().size();i++){
                        System.out.println((i+1)+". "+hospital.getDoctors().get(i).getName());
                    }
                    System.out.println("Enter index to get more details :");
                    int doctorIndex2 = sc.nextInt() - 1;
                    Doctor selectedDoctor2 = hospital.getDoctors().get(doctorIndex2);
                    System.out.println("Name : " +selectedDoctor2.getName());
                    System.out.println("Specialization : " + selectedDoctor2.getSpecialization());
                    System.out.println("Phone : " + selectedDoctor2.getPhone());
                    System.out.println("Address : " + selectedDoctor2.getAddress());
                    List<Appointment> doctor2Appointments = selectedDoctor2.getAppointments();
                    if (doctor2Appointments.isEmpty()) {
                        System.out.println("No Appointments available");
                    } else {
                        System.out.println("Appointments available :");
                        for (Appointment doctor2Appointment : doctor2Appointments) {
                            System.out.println("Patient = "+doctor2Appointment.getPatient().getName());
                            System.out.println("Date and time of appointment = "+doctor2Appointment.getDateAndTime());
                        }
                    }
                    break;
                case 5: //Exit from project
                    System.out.println("Exiting from application");
                    System.exit(0);
                    break;
                default: System.out.println("Invalid choice try again please :");
                    break;
            }
        }
        sc.close();
    }
}