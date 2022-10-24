package validators.cpf;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

import validators.validator.Validator;

public class CpfValidator extends Validator{
    private List<Integer> digits;

    public CpfValidator() {
        super("(\\d{3}.){2}\\d{3}-\\d{2}");
        
        this.digits = new ArrayList<Integer>();
    }

    private static int get_verification_value(List<Integer> digits){
        int acc = 0;

        for(int pos = 0; pos < digits.size(); pos++){
            int multiplier = digits.size() - pos + 1;

            acc += digits.get(pos) * multiplier;
        }

        int verification = (acc * 10) % 11;

        if(verification == 10){
            return 0;
        }

        return verification;
    }

    private boolean has_correct_digit_number(){
        return this.digits.size() == 11;
    }

    private boolean is_first_verification_valid(){
        Integer verification = CpfValidator.get_verification_value(this.digits.subList(0, 9));

        return this.digits.get(9) == verification;
    }

    private boolean is_second_verification_valid(){
        Integer verification = CpfValidator.get_verification_value(this.digits.subList(0, 10));

        return this.digits.get(10) == verification;
    }

    public boolean is_format_valid(String cpf) {
        return Pattern.compile(this.pattern)
            .matcher(cpf)
            .matches();
    }

    public boolean is_value_valid(String cpf){
        this.set_cpf_digits(cpf);

        if(!this.has_correct_digit_number()) {
            return false;
        }
        
        if(!this.is_first_verification_valid()){
            return false;
        }
        
        if(!this.is_second_verification_valid()){
            return false;
        }

        return true;
    }

    public boolean is_valid(String cpf) {
        if(!this.is_format_valid(cpf)){
            return false;
        }

        if(!this.is_value_valid(cpf)){
            return false;
        }

        return true;
    }

    private void set_cpf_digits(String cpf){
        List<Integer> digits = new ArrayList<Integer>();
       
        for(char digit : cpf.toCharArray()){
            Integer numeric_digit = Character.getNumericValue(digit);
            digits.add(numeric_digit);
        }

        this.digits = digits;
    }
    
}
