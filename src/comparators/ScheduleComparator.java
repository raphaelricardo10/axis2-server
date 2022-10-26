package comparators;


import java.util.Comparator;

import schedule.DailySchedule;

public class ScheduleComparator implements Comparator<DailySchedule> {
    @Override
    public int compare(DailySchedule sch1, DailySchedule sch2) {
        return sch1.getDate().compareTo(sch2.getDate());
    }
}