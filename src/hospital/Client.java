package hospital;

import email.EmailValidator;
import phoneNumber.PhoneNumberValidator;

public class Client {

    private int cpf;
    private String name;
    private String email;
    private String phoneNumber;

    Client(String name, String email, int cpf, String phoneNumber) throws Exception{
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;

        this.validate_fields();
    }

    private static void validate_email(String email) throws Exception {
        if(!EmailValidator.is_valid(email)) {
            throw new Exception("The email supplied is invalid");
        }
    }

    private static void validate_phone_number(String phoneNumber) throws Exception {
        if(!PhoneNumberValidator.is_valid(phoneNumber)) {
            throw new Exception("The phone number supplied is invalid. The format must be (xx) xxxxx-xxxx");
        }
    }

    private void validate_fields() throws Exception {
        Client.validate_email(this.email);
        Client.validate_phone_number(this.phoneNumber);
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
        Client.validate_email(email);
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        Client.validate_phone_number(phoneNumber);
        this.phoneNumber = phoneNumber;
    }
}
