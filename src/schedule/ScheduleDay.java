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

    private boolean is_in_working_time() {
        return this.dayIterator.isBefore(this.workTime.getEnd());
    }

    private boolean is_in_lunch_time() {
        if(this.dayIterator.equals(this.launchTime.getStart())){
            return true;
        }

        if(this.dayIterator.isBefore(this.launchTime.getStart())){
            return false;
        }
        
        if(this.dayIterator.isAfter(this.launchTime.getEnd())){
            return false;
        }

        return true;
    }

    private void skip_launch_time() {
        this.dayIterator = this.launchTime.getEnd();   
    }

    private void advance() {
        this.dayIterator = this.dayIterator.plusMinutes(this.duration);
    }

    private void generateSlots() { 
        while(this.is_in_working_time()){
            if(this.is_in_lunch_time()){
                this.skip_launch_time();
            }

            this.freeSlots.add(this.dayIterator);
            this.advance();
        }
    }

    public Set<LocalTime> getFreeSlots() {
        return this.freeSlots;
    }
}
