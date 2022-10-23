package email;

import java.util.regex.Pattern;

public class EmailValidator {
    private final static String pattern = 
        "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean is_valid(String email) {
        return Pattern.compile(EmailValidator.pattern)
                .matcher(email)
                .matches();
    }
}
