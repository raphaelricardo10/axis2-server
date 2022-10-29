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

    public void validateEmail(String email) throws Exception {
        if(!this.emailValidator.isValid(email)) {
            throw new Exception("The email supplied is invalid");
        }
    }

    public void validatePhoneNumber(String phoneNumber) throws Exception {
        if(!this.phoneNumberValidator.isValid(phoneNumber)) {
            throw new Exception("The phone number supplied is invalid. The format must be (xx) xxxxx-xxxx");
        }
    }

    public void validateCpf(String cpf) throws Exception {
        if(!this.cpfValidator.isFormatValid(cpf)) {
            throw new Exception("The format of CPF is invalid. You must provide in the format xxx.xxx.xxx-xx");
        }

        if(!this.cpfValidator.isFormatValid(cpf)) {
            throw new Exception("The value of CPF is invalid. Please check it and try again.");
        }
    }

    public void validateFields(String email, String phoneNumber, String cpf) throws Exception {
        this.validateCpf(cpf);
        this.validateEmail(email);
        this.validatePhoneNumber(phoneNumber);
    }
}