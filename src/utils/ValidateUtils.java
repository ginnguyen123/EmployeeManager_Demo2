package utils;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String FULL_NAME = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
    public static final String PHONE_NUMBER = "^(0|84)(3|5|7|8|9)([0987654321]{8})$";
    public static final String EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";
    public static final String DATE_DAY = "^\\d{2}-\\d{2}-\\d{4}$";

    public static boolean isFullNameValidate(String fullName){
        return Pattern.compile(FULL_NAME).matcher(fullName).matches();
    }
    public static boolean isPhoneNumberValidate(String phoneNumber){
        return Pattern.compile(PHONE_NUMBER).matcher(phoneNumber).matches();
    }
    public static boolean isEmail(String email){
        return Pattern.compile(EMAIL).matcher(email).matches();
    }
    public static boolean isBirthDay(String brithDay){
        return Pattern.compile(DATE_DAY).matcher(brithDay).matches();
    }
}
