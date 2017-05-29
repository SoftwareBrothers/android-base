package com.rstit.base.di.base;

import android.support.annotation.NonNull;

import com.rstit.base.di.names.EmailValidatorName;
import com.rstit.base.di.names.NonEmptyValidatorName;
import com.rstit.base.di.names.PasswordValidatorName;
import com.rstit.base.validation.EmailValidator;
import com.rstit.base.validation.NonEmptyFieldValidator;
import com.rstit.base.validation.PasswordValidator;
import com.rstit.base.validation.Validator;

import javax.inject.Singleton;

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