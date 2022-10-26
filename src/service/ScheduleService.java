package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import hospital.Doctor;
import mock.MockData;
import person.Person;
import schedule.doctor.DoctorSchedule;

public class ScheduleService {
    private Map<Doctor, DoctorSchedule> schedules;

    public ScheduleService() throws Exception {
        this.schedules = new HashMap<Doctor, DoctorSchedule>();
        
        Doctor doctor = MockData.makeDoctor();
        DoctorSchedule schedule = MockData.makeDoctorSchedule(doctor);

        this.schedules.put(doctor, schedule);
    }

    public DoctorSchedule getDoctorSchedule(Doctor doctor) {
        return this.schedules.get(doctor);
    }
}
