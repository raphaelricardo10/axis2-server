package validators.email;

import java.util.regex.Pattern;

import validators.validator.Validator;

public class EmailValidator extends Validator {
    public EmailValidator() {
        super("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    @Override
    public boolean is_valid(String email) {
        return Pattern.compile(this.pattern)
                .matcher(email)
                .matches();
    }
}
