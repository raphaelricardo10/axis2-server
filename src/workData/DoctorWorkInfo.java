package workData;

import java.util.Set;
import java.time.DayOfWeek;

import hospital.Doctor;

public class DoctorWorkInfo {
    private Doctor doctor;
    private DayOfWork dayOfWork;
    private Set<DayOfWeek> workingDays;

    public DoctorWorkInfo(Doctor doctor, DayOfWork dayOfWork, Set<DayOfWeek> workingDays) {
        this.doctor = doctor;
        this.dayOfWork = dayOfWork;
        this.workingDays = workingDays;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
}
