package schedule;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleDay {
    private int duration;
    private LocalDate date;
    private LocalTime dayIterator;
    private ScheduleInterval workTime;
    private ScheduleInterval launchTime;
    private Set<LocalTime> freeSlots;

    public ScheduleDay(int duration, ScheduleInterval workTime, ScheduleInterval launchTime, LocalDate date) {
        this.date = date;
        this.duration = duration;
        this.workTime = workTime;
        this.launchTime = launchTime;
        this.freeSlots = new HashSet<LocalTime>();
        this.dayIterator = this.workTime.getStart();

        this.generateSlots();
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public Set<LocalTime> getFreeSlots() {
        return this.freeSlots;
    }

    public void addSlot(LocalTime slot) {
        this.freeSlots.add(slot);
    }

    public void removeSlot(LocalTime slot) {
        this.freeSlots.remove(slot);
    }

    private boolean is_in_working_time() {
        return this.dayIterator.isBefore(this.workTime.getEnd());
    }

    private boolean is_in_lunch_time() {
        if (this.dayIterator.equals(this.launchTime.getStart())) {
            return true;
        }

        if (this.dayIterator.isBefore(this.launchTime.getStart())) {
            return false;
        }

        if (this.dayIterator.isAfter(this.launchTime.getEnd())) {
            return false;
        }

        return true;
    }

    private void skip_launch_time() {
        this.dayIterator = this.launchTime.getEnd();
    }

    private void advanceIterator() {
        this.dayIterator = this.dayIterator.plusMinutes(this.duration);
    }

    private void generateSlots() {
        while (this.is_in_working_time()) {
            if (this.is_in_lunch_time()) {
                this.skip_launch_time();
            }

            this.freeSlots.add(this.dayIterator);
            this.advanceIterator();
        }
    }
}
