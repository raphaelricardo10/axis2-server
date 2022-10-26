package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import hospital.Doctor;
import mock.MockData;
import person.Person;
import schedule.doctor.DoctorSchedule;

public class MyService {
    private Set<Person> clients;
    private Map<Doctor, DoctorSchedule> schedules;

    public MyService() throws Exception {
        this.clients = new HashSet<>();
        this.schedules = new HashMap<Doctor, DoctorSchedule>();

        this.setUp();
    }
    
    private void setUp() throws Exception {
        Doctor doctor = MockData.makeDoctor();
        Person person = MockData.makePerson("Lucas Ferreira");

        this.clients.add(person);
        this.schedules.put(doctor, MockData.makeDoctorSchedule(doctor));
    }

    public Set<Doctor> getDoctors() {
        return this.schedules.keySet();
    }

    public Set<Person> getClients() {
        return this.clients;
    }

    public DoctorSchedule getDoctorSchedule(Doctor doctor) {
        return this.schedules.get(doctor);
    }
}
