package service;

import java.util.HashSet;
import java.util.Set;

import hospital.Doctor;
import mock.MockData;

public class DoctorService {
    private Set<Doctor> doctors;

    public DoctorService() throws Exception {
        this.doctors = new HashSet<Doctor>();
        this.doctors.add(MockData.makeDoctor());
    }

    public Set<Doctor> getDoctors() {
        return this.doctors;
    }
}
