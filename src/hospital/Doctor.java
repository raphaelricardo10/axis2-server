package hospital;

import java.util.Date;

import person.Gender;
import person.Person;

public class Doctor extends Person{
    private String crm;
    private Specialty[] specialties;

    public Doctor(String name, String email, int cpf, Gender gender, String phoneNumber, Date birthDate, String crm, Specialty[] specialties) throws Exception {
        super(name, email, cpf, gender, phoneNumber, birthDate);
        this.crm = crm;
        this.specialties = specialties;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Specialty[] getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Specialty[] specialties) {
        this.specialties = specialties;
    }
}
