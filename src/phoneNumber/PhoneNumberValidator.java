package phoneNumber;

import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private final static String pattern = "^([1-9]{2}) (?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$";

    public static boolean is_valid(String email) {
        return Pattern.compile(PhoneNumberValidator.pattern)
                .matcher(email)
                .matches();
    }
}
