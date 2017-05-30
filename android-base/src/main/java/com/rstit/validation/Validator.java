package com.rstit.validation;

import android.support.annotation.Nullable;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
public interface Validator {
    boolean isValid(@Nullable String text);
}