package test;

import java.time.LocalTime;

import junit.framework.TestCase;
import schedule.ScheduleDay;
import schedule.ScheduleInterval;

public class ScheduleTest extends TestCase{
    public void testSlotsGenerated() {
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));

        ScheduleDay day = new ScheduleDay(30, workTime, lunchTime);

        assertEquals(day.getFreeSlots().size(), 14);
        assertFalse(day.getFreeSlots().contains(lunchTime.getStart()));
    }
}
