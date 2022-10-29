package test;

import junit.framework.TestCase;
import validators.validator.Validator;
import validators.cpf.CpfValidator;
import validators.email.EmailValidator;
import validators.phoneNumber.PhoneNumberValidator;

public class ValidatorsTest extends TestCase {
    private static <T extends Validator> boolean isAllValid(String[] data, T validator) {
        for (String o : data) {
            if (!validator.isValid(o)) {
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

        assertTrue(validator.isValid(validEmail));

        assertFalse(ValidatorsTest.isAllValid(invalidEmails, validator));

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

        assertTrue(ValidatorsTest.isAllValid(validPhoneNumbers, validator));
        assertFalse(ValidatorsTest.isAllValid(invalidPhoneNumbers, validator));
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

        assertTrue(validator.isValid(validCpf));
        assertFalse(ValidatorsTest.isAllValid(invalidCpfs, validator));
    }
}
