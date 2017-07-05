package com.rstit.di.base;

import android.support.annotation.NonNull;

import com.rstit.di.names.EmailValidatorName;
import com.rstit.di.names.NonEmptyValidatorName;
import com.rstit.di.names.PasswordValidatorName;
import com.rstit.validation.EmailValidator;
import com.rstit.validation.NonEmptyFieldValidator;
import com.rstit.validation.PasswordValidator;
import com.rstit.validation.Validator;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Tomasz Trybala
 * @since 28.03.2017
 */
@Module
public class TestValidationModule {
    @Provides
    @Singleton
    @EmailValidatorName
    public @NonNull Validator provideEmailValidator() {
        return Mockito.mock(EmailValidator.class);
    }

    @Provides
    @Singleton
    @PasswordValidatorName
    public @NonNull Validator providePasswordValidator() {
        return Mockito.mock(PasswordValidator.class);
    }

    @Provides
    @Singleton
    @NonEmptyValidatorName
    public @NonNull Validator provideNonEmptyFieldValidator() {
        return Mockito.mock(NonEmptyFieldValidator.class);
    }
}