package allocation;

import java.time.LocalDateTime;

import hospital.Specialty;
import person.Person;

public class ClientAllocation {
    private Person client;
    private Specialty specialty;
    private LocalDateTime scheduledTo;
    private LocalDateTime createdAt;

    public ClientAllocation(Person client, Specialty specialty, LocalDateTime scheduledTo) {
        this.client = client;
        this.specialty = specialty;
        this.scheduledTo = scheduledTo;
        this.createdAt = LocalDateTime.now();
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public LocalDateTime getScheduleTime() {
        return this.scheduledTo;
    }

    public void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduledTo = scheduleTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
