package mock;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import hospital.Doctor;
import hospital.Specialty;
import person.Gender;
import person.Person;
import schedule.ScheduleInterval;
import schedule.doctor.DoctorSchedule;
import workData.DayOfWork;
import workData.WorkInfo;

public class MockData {
    public static DayOfWork makeDayOfWork() {
        int appointmentDuration = 30;
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));
        
        return new DayOfWork(appointmentDuration, workTime, lunchTime);
    }
    
    public static Person makePerson(String name) throws Exception {
        return new Person(name, "raphaelricardo10@gmail.com", "161.491.137-10", Gender.MALE,
        "(21) 98678-6884", LocalDate.of(1996, 12, 27));
    }

    public static Person makePerson() throws Exception {
        return MockData.makePerson("Raphael Gonçalves");
    }
    
    public static WorkInfo makeWorkInfo() {
        DayOfWork dayOfWork = MockData.makeDayOfWork();
        DayOfWeek[] daysOfWeek = { DayOfWeek.THURSDAY, DayOfWeek.TUESDAY };
        
        return new WorkInfo(dayOfWork, daysOfWeek);
    }

    public static Doctor makeDoctor(Person person) throws Exception {
        Specialty[] specialties = { Specialty.FAMILY_MEDICINE };

        return new Doctor(person, "123456", specialties);
    }

    public static Doctor makeDoctor() throws Exception {
        Person person = MockData.makePerson();

        return MockData.makeDoctor(person);
    }

    public static DoctorSchedule makeDoctorSchedule(Doctor doctor) throws Exception {
        WorkInfo workInfo = MockData.makeWorkInfo();
        LocalDate startDate = LocalDate.of(2022, 10, 25);

        return new DoctorSchedule(doctor, workInfo, startDate);
    }

    public static DoctorSchedule makeDoctorSchedule() throws Exception {
        Doctor doctor = MockData.makeDoctor();
        
        return MockData.makeDoctorSchedule(doctor);
    }
}
