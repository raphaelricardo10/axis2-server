package person;

import validators.client.ClientValidator;

public class Person {

    private int cpf;
    private String name;
    private String email;
    private String phoneNumber;
    private ClientValidator validator;

    Person(String name, String email, int cpf, String phoneNumber) throws Exception{        
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

    public void setPhoneNumber(String phoneNumber) throws Exception {
        this.validator.validate_phone_number(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
