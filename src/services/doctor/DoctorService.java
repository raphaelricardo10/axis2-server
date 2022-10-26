package services.doctor;

import hospital.Doctor;
import mock.MockData;

public class DoctorService {
    private Doctor[] doctors;

    public DoctorService() throws Exception {
        this.doctors = new Doctor[] { MockData.makeDoctor() };
    }

    public Doctor[] getDoctors() {
        return this.doctors;
    }
}
