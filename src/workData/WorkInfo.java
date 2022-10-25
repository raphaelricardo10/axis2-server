package workData;

import java.util.Set;
import java.time.DayOfWeek;


public class WorkInfo {
    private DayOfWork dayOfWork;
    private Set<DayOfWeek> workingDays;
    private int appointmentDuration;

    public WorkInfo(DayOfWork dayOfWork, DayOfWeek[] workingDays) {
        this.dayOfWork = dayOfWork;
        this.workingDays = Set.of(workingDays);
    }

    public DayOfWork getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(DayOfWork dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public Set<DayOfWeek> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Set<DayOfWeek> workingDays) {
        this.workingDays = workingDays;
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(int appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }
}
