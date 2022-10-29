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

    private static int getVerificationDigit(List<Integer> digits){
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

    private boolean hasCorrectDigitNumber(){
        return this.digits.size() == 11;
    }

    private boolean hasDifferentDigits(){
        return !this.digits.stream().allMatch(s -> s.equals(this.digits.get(0)));
    }

    private boolean isFirstVerificationValid(){
        Integer verification = CpfValidator.getVerificationDigit(this.digits.subList(0, 9));

        return this.digits.get(9) == verification;
    }

    private boolean isSecondVerificationValid(){
        Integer verification = CpfValidator.getVerificationDigit(this.digits.subList(0, 10));

        return this.digits.get(10) == verification;
    }

    public boolean isFormatValid(String cpf) {
        return Pattern.compile(this.pattern)
            .matcher(cpf)
            .matches();
    }

    public boolean isValueValid(String cpf){
        this.setCpfDigits(cpf);

        if(!this.hasCorrectDigitNumber()) {
            return false;
        }

        if(!this.hasDifferentDigits()){
            return false;
        }
        
        if(!this.isFirstVerificationValid()){
            return false;
        }
        
        if(!this.isSecondVerificationValid()){
            return false;
        }

        return true;
    }

    public boolean isValid(String cpf) {
        if(!this.isFormatValid(cpf)){
            return false;
        }

        if(!this.isValueValid(cpf)){
            return false;
        }

        return true;
    }

    private void setCpfDigits(String cpf){
        cpf = cpf.replaceAll("\\D+","");

        List<Integer> digits = new ArrayList<Integer>();
       
        for(char digit : cpf.toCharArray()){
            Integer numericDigit = Character.getNumericValue(digit);
            digits.add(numericDigit);
        }

        this.digits = digits;
    }
    
}
