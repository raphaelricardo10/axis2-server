package schedule.doctor;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import allocation.ClientAllocation;
import comparators.ScheduleComparator;
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
    private TreeSet<DailySchedule> schedule;
    private Set<ClientAllocation> allocations;

    public DoctorSchedule(Doctor doctor, WorkInfo workInfo, LocalDate startDate) {
        this.doctor = doctor;
        this.workInfo = workInfo;
        this.startDate = startDate;
        this.dayIterator = startDate;
        this.endDate = startDate.plusDays(30);
        this.schedule = new TreeSet<DailySchedule>(new ScheduleComparator());
        this.allocations = new HashSet<ClientAllocation>();

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

    public DailySchedule getSchedule(LocalDate date) {
        return this.schedule.stream().filter(sch -> sch.getDate().equals(date)).findFirst().get();
    }

    public Set<ClientAllocation> getAllocations() {
        return this.allocations;
    }

    private DailySchedule getFirstAvailableSchedule() {
        return this.schedule.stream().filter(sch -> sch.hasAvailableTime()).findFirst().get();
    }

    public LocalDateTime getFirstAvailableTime() {
        DailySchedule schedule = this.getFirstAvailableSchedule();
        return LocalDateTime.of(schedule.getDate(), schedule.getFirstAvailableTime());
    }

    public Set<ClientAllocation> getAllocations(String cpf) {
        return this.allocations.stream().filter(al -> al.getClient().getCpf().startsWith(cpf))
                .collect(Collectors.toSet());
    }

    public boolean clientHasAllocation(String cpf) {
        return this.getAllocations(cpf).size() > 0;
    }

    public Set<ClientAllocation> getAllocations(LocalDate date) {
        return this.allocations.stream().filter(al -> al.getScheduleTime().toLocalDate().equals(date))
                .collect(Collectors.toSet());
    }

    private void validateSpecialty(Specialty specialty) throws Exception {
        if (!this.doctor.hasSpecialty(specialty)) {
            throw new Exception("The doctor does not has this specialty");
        }
    }

    public void allocateClient(Person client, Specialty specialty, LocalDateTime scheduledTo) throws Exception {
        this.validateSpecialty(specialty);

        this.allocations.add(new ClientAllocation(client, specialty, scheduledTo));
        this.getSchedule(scheduledTo.toLocalDate()).removeAvailableTime(scheduledTo.toLocalTime());
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
