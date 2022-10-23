package validators.validator;

public abstract class Validator {
    protected final String pattern;

    protected Validator(String pattern) {
        this.pattern = pattern;
    }

    abstract public boolean is_valid(String value);
}
