package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import hospital.Doctor;
import hospital.Specialty;
import junit.framework.TestCase;
import person.Gender;
import person.Person;
import schedule.DailySchedule;
import schedule.ScheduleInterval;
import schedule.doctor.DoctorSchedule;
import workData.DayOfWork;
import workData.WorkInfo;

public class AllocationTest extends TestCase {
    private Person client;
    private DoctorSchedule schedule;

    @Before
    public void setUp() throws Exception {
        int appointmentDuration = 30;
        DayOfWeek[] daysOfWeek = { DayOfWeek.THURSDAY, DayOfWeek.TUESDAY };
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));

        DayOfWork dayOfWork = new DayOfWork(appointmentDuration, workTime, lunchTime);
        WorkInfo workInfo = new WorkInfo(dayOfWork, daysOfWeek);
        LocalDate startDate = LocalDate.of(2022, 10, 24);
        Specialty[] specialties = { Specialty.FAMILY_MEDICINE };

        Doctor doctor = new Doctor("Raphael Gonçalves", "raphaelricardo10@gmail.com", "161.491.137-10", Gender.MALE,
                "(21) 98678-6884", LocalDate.of(1996, 12, 27), "123456", specialties);

        this.client = new Person("Name", "mail@domain.com", "161.491.137-10", Gender.MALE, "(21) 98678-6884",
                LocalDate.of(1996, 12, 27));

        this.schedule = new DoctorSchedule(doctor, workInfo, startDate);
    }

    @Test
    public void testAllocateClient() throws Exception {
        DailySchedule scheduleOfDay = this.schedule.getSchedule(LocalDate.of(2022, 10, 25));
        LocalTime freeTime = scheduleOfDay.getFreeSlots().iterator().next();

        LocalDateTime allocationDateTime = LocalDateTime.of(scheduleOfDay.getDate(), freeTime);

        this.schedule.allocateClient(this.client, Specialty.FAMILY_MEDICINE, allocationDateTime);
    }
}
