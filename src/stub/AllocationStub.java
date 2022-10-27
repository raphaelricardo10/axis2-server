package stub;

import allocation.ClientAllocation;
import hospital.Doctor;

public class AllocationStub {
    private String specialty;
    private DoctorStub doctor;
    private PersonStub client;
    private String appointmentDate;

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
}
