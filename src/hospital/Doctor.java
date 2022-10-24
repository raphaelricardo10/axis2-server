package hospital;

import java.util.Date;

import person.Gender;
import person.Person;

public class Doctor extends Person{
    private String crm;
    private String specialization;

    public Doctor(String name, String email, int cpf, Gender gender, String phoneNumber, Date birthDate, String crm, String specialization) throws Exception {
        super(name, email, cpf, gender, phoneNumber, birthDate);
        this.crm = crm;
        this.specialization = specialization;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
