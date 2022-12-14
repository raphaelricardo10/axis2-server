package test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Test;

import mock.MockData;
import workData.DayOfWork;
import schedule.DailySchedule;
import junit.framework.TestCase;
import schedule.doctor.DoctorSchedule;

public class ScheduleTest extends TestCase {

    @Test
    public void testCanGenerateAvailableTimes() {
        DayOfWork dayOfWork = MockData.makeDayOfWork();
        DailySchedule day = new DailySchedule(dayOfWork, LocalDate.of(2022, 10, 25));

        assertEquals(day.getAvailableTimes().size(), 14);
        assertFalse(day.getAvailableTimes().contains(dayOfWork.getLunchTime().getStart()));
    }

    @Test
    public void testCanGenerateMonthlySchedule() throws Exception {
        DoctorSchedule schedule = MockData.makeDoctorSchedule();

        assertEquals(schedule.getSchedule().size(), 10);

        for (DailySchedule day : schedule.getSchedule()) {
            DayOfWeek dayOfWeek = day.getDate().getDayOfWeek();
            assertTrue(schedule.getWorkInfo().getWorkingDays().contains(dayOfWeek));
        }
    }
}
