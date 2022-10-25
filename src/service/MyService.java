package service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hospital.Doctor;
import hospital.Specialty;
import person.Gender;
import schedule.ScheduleInterval;
import schedule.doctor.DoctorSchedule;
import workData.DayOfWork;
import workData.WorkInfo;

public class MyService {
    private Map<Doctor, DoctorSchedule> schedules;

    public MyService() {
        this.schedules = new HashMap<Doctor, DoctorSchedule>();
        this.setUp();
    }

    private void setUp() {
        int appointmentDuration = 30;
        DayOfWeek[] daysOfWeek = { DayOfWeek.THURSDAY, DayOfWeek.TUESDAY };
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));

        DayOfWork dayOfWork = new DayOfWork(appointmentDuration, workTime, lunchTime);
        WorkInfo workInfo = new WorkInfo(dayOfWork, daysOfWeek);
        LocalDate startDate = LocalDate.of(2022, 10, 24);
        Specialty[] specialties = { Specialty.FAMILY_MEDICINE };

        Doctor doctor;
        try {
            doctor = new Doctor("Raphael Gonçalves", "raphaelricardo10@gmail.com", "161.491.137-10", Gender.MALE,
                    "(21) 98678-6884", LocalDate.of(1996, 12, 27), "123456", specialties);
            DoctorSchedule schedule = new DoctorSchedule(doctor, workInfo, startDate);
            this.schedules.put(doctor, schedule);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<Doctor> getDoctors() {
        return this.schedules.keySet();
    }
}
