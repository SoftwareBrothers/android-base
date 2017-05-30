package com.rstit.validation;

import android.support.annotation.Nullable;

import com.google.common.base.Strings;

import java.util.regex.Pattern;

/**
 * @author Tomasz Trybala
 * @since 28.03.2017
 */
public class EmailValidator implements Validator {
    private static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    @Override
    public boolean isValid(@Nullable String text) {
        return !Strings.isNullOrEmpty(text) && EMAIL_ADDRESS_PATTERN.matcher(text).matches();
    }
}