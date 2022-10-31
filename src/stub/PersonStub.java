package stub;

import person.Person;
import validators.client.ClientValidator;

public class PersonStub {
    private String cpf;
    private String name;
    private String email;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private ClientValidator validator;

    public PersonStub(String name, String email, String cpf, String gender, String phoneNumber, String birthDate)
            throws Exception {
        this.validator = new ClientValidator();
        this.validator.validateFields(email, phoneNumber, cpf);

        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public PersonStub(Person person) throws Exception {
        this(person.getName(), person.getEmail(), person.getCpf(), person.getGender().toString(),
                person.getPhoneNumber(), person.getBirthDate().toString());
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

    public void validateFields() throws Exception {
        this.validator.validateFields(this.email, this.phoneNumber, this.cpf);
    }
}
