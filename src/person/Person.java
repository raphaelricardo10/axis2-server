package person;

import validators.client.ClientValidator;

public class Person {

    private int cpf;
    private String name;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private ClientValidator validator;

    public Person(String name, String email, int cpf, Gender gender, String phoneNumber) throws Exception{        
        this.validator = new ClientValidator();
        this.validator.validate_fields(email, phoneNumber);

        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        this.validator.validate_email(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        this.validator.validate_phone_number(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
