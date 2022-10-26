package stub;

import person.Person;

public class PersonStub {
    private String cpf;
    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private String phoneNumber;

    public PersonStub(Person person) throws Exception {
        this.cpf = person.getCpf();
        this.name = person.getName();
        this.email = person.getEmail();
        this.phoneNumber = person.getPhoneNumber();
        this.gender = person.getGender().toString();
        this.birthDate = person.getBirthDate().toString();
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
}
