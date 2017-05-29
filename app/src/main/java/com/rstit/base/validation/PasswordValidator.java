package com.rstit.base.validation;

import android.support.annotation.Nullable;

/**
 * @author Tomasz Trybala
 * @since 28.03.2017
 */
public class PasswordValidator implements Validator {
    private static final int MIN_LENGTH = 6;

    @Override
    public boolean isValid(@Nullable String text) {
        return text != null && text.length() >= MIN_LENGTH;
    }
}