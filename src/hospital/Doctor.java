package hospital;

import java.util.Date;

import person.Gender;
import person.Person;

public class Doctor extends Person{
    private String crm;
    private Specialty specialty;

    public Doctor(String name, String email, int cpf, Gender gender, String phoneNumber, Date birthDate, String crm, Specialty specialty) throws Exception {
        super(name, email, cpf, gender, phoneNumber, birthDate);
        this.crm = crm;
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Specialty getSpecialization() {
        return specialty;
    }

    public void setSpecialization(Specialty specialty) {
        this.specialty = specialty;
    }
}
