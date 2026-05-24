package validation;

public class InputValidator {
    public static <T> T parseType(String str, Class<T> type){
        try {
            if (type == Integer.class) {
                return type.cast(Integer.parseInt(str));

            } else if (type == Long.class) {
                return type.cast(Long.parseLong(str));

            } else if (type == Double.class) {
                return type.cast(Double.parseDouble(str));
            }
            throw new IllegalArgumentException("지원하지 않는 타입"); //type 지원하지 않을 경우

        }catch (NumberFormatException e){  //str을 type으로 변환 불가능
            return null;
        }
    }
}
