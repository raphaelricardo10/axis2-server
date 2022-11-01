package stub;

import java.util.Set;

import hospital.Doctor;
import hospital.Specialty;

public class DoctorStub {
    private String crm;
    private String cpf;
    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String[] specialties;

    public DoctorStub() {
    }

    public DoctorStub(Doctor doctor) {
        this.crm = doctor.getCrm();
        this.cpf = doctor.getCpf();
        this.name = doctor.getName();
        this.email = doctor.getEmail();
        this.phoneNumber = doctor.getPhoneNumber();
        this.gender = doctor.getGender().toString();
        this.birthDate = doctor.getBirthDate().toString();
        this.specialties = new String[doctor.getSpecialties().size()];

        this.copySpecialties(doctor.getSpecialties());
    }

    public String getCrm() {
        return crm;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String[] getSpecialties() {
        return specialties;
    }

    private void copySpecialties(Set<Specialty> specialties) {
        int i = 0;
        for (Specialty specialty : specialties) {
            this.specialties[i++] = specialty.toString();
        }
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSpecialties(String[] specialties) {
        this.specialties = specialties;
    }
}
