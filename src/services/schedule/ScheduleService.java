package services.schedule;

import java.util.Map;
import java.time.LocalDateTime;
import java.util.HashMap;

import mock.MockData;
import person.Person;
import hospital.Doctor;
import hospital.Specialty;
import schedule.doctor.DoctorSchedule;

public class ScheduleService {
    private Map<String, Person> clients;
    private Map<String, DoctorSchedule> schedules;

    public ScheduleService() throws Exception {
        this.clients = new HashMap<String, Person>();
        this.schedules = new HashMap<String, DoctorSchedule>();

        Doctor doctor = MockData.makeDoctor();
        Person client = MockData.makePerson("Lucas Ferreira");
        DoctorSchedule schedule = MockData.makeDoctorSchedule(doctor);

        this.clients.put(client.getCpf(), client);
        this.schedules.put(doctor.getCrm(), schedule);
    }

    public String getFirstAvailableDate(String crm) {
        return this.schedules.get(crm).getFirstAvailableTime().toString();
    }

    public void allocateClient(String clientCpf, String doctorCrm, String specialty, String availableTime) throws Exception {
        Person client = this.clients.get(clientCpf);
        Specialty specialtyObj = Specialty.valueOf(specialty);
        LocalDateTime availableTimeObj = LocalDateTime.parse(availableTime);

        this.schedules.get(doctorCrm).allocateClient(client, specialtyObj, availableTimeObj);
    }
}
