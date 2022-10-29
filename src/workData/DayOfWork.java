package workData;

import schedule.ScheduleInterval;

public class DayOfWork {
    private int appointmentDuration;
    private ScheduleInterval workTime;
    private ScheduleInterval lunchTime;

    public DayOfWork(int appointmentDuration, ScheduleInterval workTime, ScheduleInterval lunchTime) {
        this.workTime = workTime;
        this.lunchTime = lunchTime;
        this.appointmentDuration = appointmentDuration;
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(int appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }

    public ScheduleInterval getWorkTime() {
        return workTime;
    }

    public void setWorkTime(ScheduleInterval workTime) {
        this.workTime = workTime;
    }

    public ScheduleInterval getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(ScheduleInterval lunchTime) {
        this.lunchTime = lunchTime;
    }
}
