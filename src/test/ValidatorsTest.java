package test;

import junit.framework.TestCase;
import validators.validator.Validator;
import validators.email.EmailValidator;
import validators.phoneNumber.PhoneNumberValidator;

public class ValidatorsTest extends TestCase {
    private static <T extends Validator> boolean is_all_valid(String[] data, T validator) {
        for (String o : data) {
            if(!validator.is_valid(o)) {
                return false;
            }
        }

        return true;
    }

    public void testValidateEmail() {
        EmailValidator validator = new EmailValidator();

        String validEmail = "email@domain.com";
        String[] invalidEmails = {
                "a@.com",
                "a.com",
                "a@a",
        };

        assertTrue(validator.is_valid(validEmail));

        assertFalse(ValidatorsTest.is_all_valid(invalidEmails, validator));

    }

    public void testValidatePhoneNumber() {
        PhoneNumberValidator validator = new PhoneNumberValidator();

        String[] validPhoneNumbers = {
            "(21) 99999-9999",
            "(21) 2602-0000"
        };

        String[] invalidPhoneNumbers = {
            "21 99999999",
            "999999999",
            "21999999999",
            "(21)999999999",
            "(21) 999999999"
        };

        assertTrue(ValidatorsTest.is_all_valid(validPhoneNumbers, validator));
        assertFalse(ValidatorsTest.is_all_valid(invalidPhoneNumbers, validator));
    }
}
