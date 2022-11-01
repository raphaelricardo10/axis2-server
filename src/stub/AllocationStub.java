package stub;

import allocation.ClientAllocation;
import hospital.Doctor;

public class AllocationStub {
    private String specialty;
    private DoctorStub doctor;
    private PersonStub client;
    private String appointmentDate;

    public AllocationStub() {
    }

    public AllocationStub(Doctor doctor, ClientAllocation allocation) throws Exception{
        this.doctor = new DoctorStub(doctor);
        this.client = new PersonStub(allocation.getClient());
        this.specialty = allocation.getSpecialty().toString();
        this.appointmentDate = allocation.getScheduleTime().toString();
    }

    public String getSpecialty() {
        return specialty;
    }

    public DoctorStub getDoctor() {
        return doctor;
    }

    public PersonStub getClient() {
        return client;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void setDoctor(DoctorStub doctor) {
        this.doctor = doctor;
    }

    public void setClient(PersonStub client) {
        this.client = client;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
