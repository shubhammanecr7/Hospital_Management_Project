import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private String phone;
    private String address;
    private List<Appointment> appointments;
    

    public Doctor(String name, String specialization, String phone, String address) {
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.address = address;
        this.appointments = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Appointment> getAppointments() {
        return this.appointments;
    }

    public void addAppointments(Appointment appointments) {
        this.appointments.add(appointments);
    }
    
    public boolean haveAppointments(){
        return !appointments.isEmpty();
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", specialization='" + getSpecialization() + "'" +
            ", phone='" + getPhone() + "'" +
            ", address='" + getAddress() + "'" +
            ", appointments='" + getAppointments() + "'" +
            "}";
    }
}
