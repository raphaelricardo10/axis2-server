package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import hospital.Specialty;
import junit.framework.TestCase;
import mock.MockData;
import person.Person;
import schedule.DailySchedule;
import schedule.doctor.DoctorSchedule;

public class AllocationTest extends TestCase {
    
    @Test
    public void testAllocateClient() throws Exception {
        Person client = MockData.makePerson();
        DoctorSchedule schedule = MockData.makeDoctorSchedule();
        DailySchedule scheduleOfDay = schedule.getSchedule(LocalDate.of(2022, 10, 25));
        LocalTime freeTime = scheduleOfDay.getFreeSlots().iterator().next();
        LocalDateTime allocationDateTime = LocalDateTime.of(scheduleOfDay.getDate(), freeTime);

        schedule.allocateClient(client, Specialty.FAMILY_MEDICINE, allocationDateTime);

        assertEquals(schedule.getAllocations(client.getName()).size(), 1);
    }
}