package validators.phoneNumber;

import validators.validator.Validator;

import java.util.regex.Pattern;

public class PhoneNumberValidator extends Validator{
    public PhoneNumberValidator() {
        super("^([1-9]{2}) (?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$");
    }

    @Override
    public boolean is_valid(String email) {
        return Pattern.compile(this.pattern)
                .matcher(email)
                .matches();
    }
}
