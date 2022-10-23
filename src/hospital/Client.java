package hospital;

import email.EmailValidator;

public class Client {

    private int cpf;
    private String name;
    private String email;
    private int phoneNumber;

    Client(String name, String email, int cpf, int phoneNumber) throws Exception{
        this.cpf = cpf;
        this.name = name;
        this.phoneNumber = phoneNumber;
        
        Client.validate_email(email);
        this.setEmail(email);;
    }

    private static void validate_email(String email) throws Exception {
        if(!EmailValidator.is_valid(email)) {
            throw new Exception("The email supplied is invalid");
        }
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
