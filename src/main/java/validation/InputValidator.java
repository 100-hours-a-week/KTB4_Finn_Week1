package validation;

public class InputValidator {
    public static boolean isInteger(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
