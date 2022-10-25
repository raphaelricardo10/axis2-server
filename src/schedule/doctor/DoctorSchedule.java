package schedule.doctor;



import java.util.Set;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import allocation.ClientAllocation;

import hospital.Doctor;
import hospital.Specialty;
import person.Person;
import workData.WorkInfo;
import schedule.DailySchedule;

public class DoctorSchedule {
    private Doctor doctor;
    private WorkInfo workInfo;
    private LocalDate dayIterator;
    private LocalDate endDate;
    private LocalDate startDate;
    private Set<DailySchedule> schedule;
    private Set<ClientAllocation> allocations;

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

    public Set<ClientAllocation> getAllocations() {
        return this.allocations;
    }

    public Set<ClientAllocation> getAllocations(String clientName) {
        return this.allocations.stream().filter(al -> al.getClient().getName().startsWith(clientName)).collect(Collectors.toSet());
    }

    public Set<ClientAllocation> getAllocations(LocalDate day) {
        return this.allocations.stream().filter(al -> al.getScheduleTime().toLocalDate().equals(day)).collect(Collectors.toSet());
    }
    
    public void allocateClient(Person client, Specialty specialty, LocalDateTime scheduledTo) throws Exception {
        this.allocations.add(new ClientAllocation(client, this.doctor, specialty, scheduledTo));
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
