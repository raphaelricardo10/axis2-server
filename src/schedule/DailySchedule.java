package schedule;

import java.util.Set;

import workData.DayOfWork;

import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalTime;

public class DailySchedule {
    private LocalDate date;
    private DayOfWork dayOfWork;
    private LocalTime dayIterator;
    private Set<LocalTime> freeSlots;

    public DailySchedule(DayOfWork dayOfWork, LocalDate date) {
        this.date = date;
        this.dayOfWork = dayOfWork;
        this.freeSlots = new HashSet<LocalTime>();

        this.generateSlots();
    }

    public DailySchedule(DayOfWork dayOfWork) {
        this(dayOfWork, LocalDate.now());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Set<LocalTime> getFreeSlots() {
        return this.freeSlots;
    }

    public void setFreeSlots(Set<LocalTime> freeSlots) {
        this.freeSlots = freeSlots;
    }

    public DayOfWork getDayOfWork() {
        return dayOfWork;
    }

    public void setDayOfWork(DayOfWork dayOfWork) {
        this.dayOfWork = dayOfWork;
    }

    public LocalTime getDayIterator() {
        return dayIterator;
    }

    public void setDayIterator(LocalTime dayIterator) {
        this.dayIterator = dayIterator;
    }

    public void addSlot(LocalTime slot) {
        this.freeSlots.add(slot);
    }

    public void removeSlot(LocalTime slot) {
        this.freeSlots.remove(slot);
    }

    private boolean is_in_working_time() {
        return this.dayIterator.isBefore(this.dayOfWork.getWorkTime().getEnd());
    }

    private boolean is_in_lunch_time() {
        if (this.dayIterator.equals(this.dayOfWork.getLaunchTime().getStart())) {
            return true;
        }

        if (this.dayIterator.isBefore(this.dayOfWork.getLaunchTime().getStart())) {
            return false;
        }

        if (this.dayIterator.isAfter(this.dayOfWork.getLaunchTime().getEnd())) {
            return false;
        }

        return true;
    }

    private void skip_launch_time() {
        this.dayIterator = this.dayOfWork.getLaunchTime().getEnd();
    }

    private void advanceIterator() {
        this.dayIterator = this.dayIterator.plusMinutes(this.dayOfWork.getAppointmentDuration());
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
