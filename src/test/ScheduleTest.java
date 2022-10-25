package test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
import schedule.DailySchedule;
import schedule.ScheduleInterval;
import schedule.doctor.DoctorSchedule;
import workData.DayOfWork;
import workData.WorkInfo;

public class ScheduleTest extends TestCase {

    private LocalDate startDate;
    private DayOfWork dayOfWork;
    private WorkInfo workInfo;

    @Before
    public void setUp() {
        int appointmentDuration = 30;
        DayOfWeek[] daysOfWeek = { DayOfWeek.THURSDAY, DayOfWeek.TUESDAY };
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));

        this.dayOfWork = new DayOfWork(appointmentDuration, workTime, lunchTime);
        this.workInfo = new WorkInfo(dayOfWork, daysOfWeek);
        this.startDate = LocalDate.of(2022, 10, 24);
    }

    @Test
    public void testSlotsGenerated() {
        DailySchedule day = new DailySchedule(this.dayOfWork);

        assertEquals(day.getFreeSlots().size(), 14);
        assertFalse(day.getFreeSlots().contains(this.dayOfWork.getLaunchTime().getStart()));
    }

    @Test
    public void testMonthlyScheduleGenerated() {
        DoctorSchedule schedule = new DoctorSchedule(null, this.workInfo, this.startDate);

        assertEquals(schedule.getSchedule().size(), 9);

        for (DailySchedule day : schedule.getSchedule()) {
            DayOfWeek dayOfWeek = day.getDate().getDayOfWeek();
            assertTrue(schedule.getWorkInfo().getWorkingDays().contains(dayOfWeek));
        }
    }
}
