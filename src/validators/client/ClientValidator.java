package validators.client;

import validators.cpf.CpfValidator;
import validators.email.EmailValidator;
import validators.phoneNumber.PhoneNumberValidator;

public class ClientValidator {
    CpfValidator cpfValidator;
    EmailValidator emailValidator;
    PhoneNumberValidator phoneNumberValidator;

    public ClientValidator() {
        this.cpfValidator = new CpfValidator();
        this.emailValidator = new EmailValidator();
        this.phoneNumberValidator = new PhoneNumberValidator();
    }

    public void validate_email(String email) throws Exception {
        if(!this.emailValidator.is_valid(email)) {
            throw new Exception("The email supplied is invalid");
        }
    }

    public void validate_phone_number(String phoneNumber) throws Exception {
        if(!this.phoneNumberValidator.is_valid(phoneNumber)) {
            throw new Exception("The phone number supplied is invalid. The format must be (xx) xxxxx-xxxx");
        }
    }

    public void validate_cpf(String cpf) throws Exception {
        if(!this.cpfValidator.is_format_valid(cpf)) {
            throw new Exception("The format of CPF is invalid. You must provide in the format xxx.xxx.xxx-xx");
        }

        if(!this.cpfValidator.is_format_valid(cpf)) {
            throw new Exception("The value of CPF is invalid. Please check it and try again.");
        }
    }

    public void validate_fields(String email, String phoneNumber, String cpf) throws Exception {
        this.validate_cpf(cpf);
        this.validate_email(email);
        this.validate_phone_number(phoneNumber);
    }
}