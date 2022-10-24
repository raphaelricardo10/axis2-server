package schedule;

import java.util.HashSet;
import java.util.Set;

import workData.DayOfWork;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class MonthlySchedule {
    private Set<ScheduleDay> days;
    private Set<DayOfWeek> workingDays;
    private LocalDate dayIterator;

    public MonthlySchedule(DayOfWeek[] workingDays) {
        this.days = new HashSet<ScheduleDay>();
        this.workingDays = Set.of(workingDays);
        this.dayIterator = LocalDate.now();

        this.generateSchedule();
    }

    public Set<ScheduleDay> getDays() {
        return days;
    }

    public Set<DayOfWeek> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(DayOfWeek[] workingDays) {
        this.workingDays = Set.of(workingDays);
    }

    public void generateSchedule() {
        LocalDate endDate = this.dayIterator.plusDays(30);

        int appointmentDuration = 30;
        ScheduleInterval workTime = new ScheduleInterval(LocalTime.of(9, 0), LocalTime.of(17, 0));
        ScheduleInterval lunchTime = new ScheduleInterval(LocalTime.of(12, 0), LocalTime.of(13, 0));

        while (!this.dayIterator.isAfter(endDate)) {
            if (this.workingDays.contains(this.dayIterator.getDayOfWeek())) {
                DayOfWork dayOfWork = new DayOfWork(appointmentDuration, workTime, lunchTime);

                this.days.add(new ScheduleDay(dayOfWork, this.dayIterator));
            }

            this.dayIterator = this.dayIterator.plusDays(1);
        }
    }

}
