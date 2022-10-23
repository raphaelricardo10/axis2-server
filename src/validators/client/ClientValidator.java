package validators.client;

import validators.email.EmailValidator;
import validators.phoneNumber.PhoneNumberValidator;

public class ClientValidator {
    EmailValidator emailValidator;
    PhoneNumberValidator phoneNumberValidator;

    public ClientValidator() {
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

    public void validate_fields(String email, String phoneNumber) throws Exception {
        this.validate_email(email);
        this.validate_phone_number(phoneNumber);
    }
}