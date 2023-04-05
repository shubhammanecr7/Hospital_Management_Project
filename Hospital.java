import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String name;
    private String address;
    private String phone;
    private List<Doctor> doctors;
    private List<Patient> patients;
    
    public Hospital(){
        this.name = null;
        this.address = null;
        this.phone = null;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public Hospital(String name, String address, String phone, List<Doctor> doctors, List<Patient> patients) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.doctors = doctors;
        this.patients = patients;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = new ArrayList<>(doctors);
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = new ArrayList<>(patients);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", doctors='" + getDoctors() + "'" +
            ", patients='" + getPatients() + "'" +
            "}";
    }
}
