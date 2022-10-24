package test;

import junit.framework.TestCase;
import validators.validator.Validator;
import validators.cpf.CpfValidator;
import validators.email.EmailValidator;
import validators.phoneNumber.PhoneNumberValidator;

public class ValidatorsTest extends TestCase {
    private static <T extends Validator> boolean is_all_valid(String[] data, T validator) {
        for (String o : data) {
            if (!validator.is_valid(o)) {
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

    public void testValidateCpf() {
        CpfValidator validator = new CpfValidator();

        String validCpf = "161.491.137-10";

        String[] invalidCpfs = {
                "16149113710",
                "161.491.13710",
                "161491137-10",
                "16149113710",
                "12345678910",
                "123.456.789-10",
                "111.111.111-11",
                "11111111111",
        };

        assertTrue(validator.is_valid(validCpf));
        assertFalse(ValidatorsTest.is_all_valid(invalidCpfs, validator));
    }
}
