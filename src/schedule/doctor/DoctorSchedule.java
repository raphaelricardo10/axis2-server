package schedule.doctor;

import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;

import hospital.Doctor;
import workData.WorkInfo;
import schedule.DailySchedule;

public class DoctorSchedule {
    private Doctor doctor;
    private WorkInfo workInfo;
    private LocalDate dayIterator;
    private LocalDate endDate;
    private LocalDate startDate;
    private Set<DailySchedule> schedule;

    public DoctorSchedule(Doctor doctor, WorkInfo workInfo, LocalDate startDate) {
        this.doctor = doctor;
        this.workInfo = workInfo;
        this.startDate = startDate;
        this.dayIterator = startDate;
        this.endDate = startDate.plusDays(30);
        this.schedule = new HashSet<DailySchedule>();

        this.generateSchedule();
    }

    public DoctorSchedule(Doctor doctor, WorkInfo workInfo) {
        this(doctor, workInfo, LocalDate.now());
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public WorkInfo getWorkInfo() {
        return workInfo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Set<DailySchedule> getSchedule() {
        return schedule;
    }

    public void generateSchedule() {
        while (!this.dayIterator.isAfter(this.endDate)) {
            if (this.workInfo.getWorkingDays().contains(this.dayIterator.getDayOfWeek())) {
                this.schedule.add(new DailySchedule(this.workInfo.getDayOfWork(), this.dayIterator));
            }

            this.dayIterator = this.dayIterator.plusDays(1);
        }
    }
}
