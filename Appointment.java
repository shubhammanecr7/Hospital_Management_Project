public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String dateAndTime;

    public Appointment(Doctor doctor, Patient patient, String dateAndTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateAndTime = dateAndTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "{" +
            " doctor='" + getDoctor() + "'" +
            ", patient='" + getPatient() + "'" +
            ", dateAndTime='" + getDateAndTime() + "'" +
            "}";
    }
    
}
