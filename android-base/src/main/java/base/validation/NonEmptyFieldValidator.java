package base.validation;

import android.support.annotation.Nullable;

import com.google.common.base.Strings;

/**
 * @author Tomasz Trybala
 * @since 26.05.2017
 */
public class NonEmptyFieldValidator implements Validator {
    @Override
    public boolean isValid(@Nullable String text) {
        return !Strings.isNullOrEmpty(text);
    }
}