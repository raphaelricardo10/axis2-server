package workData;

import java.time.LocalTime;

import schedule.ScheduleInterval;

public class DayOfWork {
    private int appointmentDuration;
    private ScheduleInterval workTime;
    private ScheduleInterval launchTime;

    public DayOfWork(int appointmentDuration, ScheduleInterval workTime, ScheduleInterval launchTime) {
        this.workTime = workTime;
        this.launchTime = launchTime;
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

    public ScheduleInterval getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(ScheduleInterval launchTime) {
        this.launchTime = launchTime;
    }
}
