package stub;

public class AllocationStub {
    private String specialty;
    private DoctorStub doctor;
    private PersonStub client;
    private String appointmentDate;

    public AllocationStub(DoctorStub doctor, PersonStub client, String specialty, String appointmentDate){
        this.doctor = doctor;
        this.client = client;
        this.specialty = specialty;
        this.appointmentDate = appointmentDate;
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
