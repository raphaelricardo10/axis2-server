package schedule;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalTime;


public class ScheduleDay {
    private int duration;
    private LocalTime dayIterator;
    private ScheduleInterval workTime;
    private ScheduleInterval launchTime;
    private Set<LocalTime> freeSlots;

    public ScheduleDay(int duration, ScheduleInterval workTime, ScheduleInterval launchTime) {
        this.duration = duration;
        this.workTime = workTime;
        this.launchTime = launchTime;
        this.freeSlots = new HashSet<LocalTime>();
        this.dayIterator = this.workTime.getStart();

        this.generateSlots();
    }

    public int getEventSize() {
        return duration;
    }

    public void setEventSize(int eventSize) {
        this.duration = eventSize;
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

    public void generateSlots() { 
        while(this.dayIterator.isBefore(this.workTime.getEnd())){
            if(this.dayIterator.isAfter(this.launchTime.getStart()) && this.dayIterator.isBefore(this.launchTime.getEnd()) || this.dayIterator.equals(this.launchTime.getStart())){
                this.dayIterator = this.launchTime.getEnd();
            }

            this.freeSlots.add(this.dayIterator);
            this.dayIterator = this.dayIterator.plusMinutes(this.duration);
        }
    }

    public Set<LocalTime> getFreeSlots() {
        return this.freeSlots;
    }
}
