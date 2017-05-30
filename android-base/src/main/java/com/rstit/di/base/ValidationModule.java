package com.rstit.di.base;

import android.support.annotation.NonNull;



import javax.inject.Singleton;

import com.rstit.di.names.EmailValidatorName;
import com.rstit.di.names.NonEmptyValidatorName;
import com.rstit.di.names.PasswordValidatorName;
import com.rstit.validation.EmailValidator;
import com.rstit.validation.NonEmptyFieldValidator;
import com.rstit.validation.PasswordValidator;
import com.rstit.validation.Validator;
import dagger.Module;
import dagger.Provides;

/**
 * @author Tomasz Trybala
 * @since 25.05.2017
 */
@Module
public class ValidationModule {
    @Provides
    @Singleton
    @EmailValidatorName
    public @NonNull Validator provideEmailValidator() {
        return new EmailValidator();
    }

    @Provides
    @Singleton
    @PasswordValidatorName
    public @NonNull Validator providePasswordValidator() {
        return new PasswordValidator();
    }

    @Provides
    @Singleton
    @NonEmptyValidatorName
    public @NonNull Validator provideNonEmptyFieldValidator() {
        return new NonEmptyFieldValidator();
    }
}