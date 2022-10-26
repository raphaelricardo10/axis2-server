package hospital;

import java.time.LocalDate;
import java.util.Set;

import person.Gender;
import person.Person;

public class Doctor extends Person{
    private String crm;
    private Set<Specialty> specialties;

    public Doctor(String name, String email, String cpf, Gender gender, String phoneNumber, LocalDate birthDate, String crm, Specialty[] specialties) throws Exception {
        super(name, email, cpf, gender, phoneNumber, birthDate);
        this.crm = crm;
        this.specialties = Set.of(specialties);
    }

    public Doctor(Person person, String crm, Specialty[] specialties) throws Exception {
        this(person.getName(), person.getEmail(), person.getCpf(),person.getGender(), person.getPhoneNumber(), person.getBirthDate(), crm, specialties);
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Set<Specialty> getSpecialties() {
        return this.specialties;
    }

    public boolean hasSpecialty(Specialty specialty){
        return this.specialties.contains(specialty);
    }
}
