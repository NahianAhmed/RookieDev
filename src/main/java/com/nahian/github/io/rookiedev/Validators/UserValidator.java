package com.nahian.github.io.rookiedev.Validators;

import com.nahian.github.io.rookiedev.Models.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    private static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern MOBILE_REGEX = Pattern.compile("^\\d{11,15}$");
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (StringUtils.isBlank(user.getName())) {
           errors.rejectValue("Name",StringUtils.EMPTY,"Name can't be empty");
        }
        Matcher mobileMatcher = MOBILE_REGEX.matcher(user.getMobile());
        if (!mobileMatcher.find()) {
           errors.rejectValue("Mobile", StringUtils.EMPTY, "Length must be 11 to 15 digits");
        }
        Matcher emailMatcher = EMAIL_REGEX.matcher(user.getEmail());
        if (!emailMatcher.find()) {
            errors.rejectValue("Email", StringUtils.EMPTY, "Invalid Email Address");
        }

    }
}
