package services.schedule;

import java.util.Map;

import allocation.ClientAllocation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mock.MockData;
import person.Person;
import hospital.Doctor;
import hospital.Specialty;
import schedule.doctor.DoctorSchedule;
import stub.AllocationStub;

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

    public AllocationStub[] getClientAllocations(String cpf) throws Exception {
        List<AllocationStub> allocations = new ArrayList<AllocationStub>();

        for (DoctorSchedule schedule : this.schedules.values()) {
            for (ClientAllocation allocation : schedule.getAllocations(cpf)) {
                allocations.add(new AllocationStub(schedule.getDoctor(), allocation));
            }
        }

        return allocations.toArray(new AllocationStub[allocations.size()]);
    }
}
