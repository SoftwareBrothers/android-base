package com.rstit.base.di.base;

import android.support.annotation.NonNull;

import com.rstit.base.di.names.EmailValidatorName;
import com.rstit.base.di.names.NonEmptyValidatorName;
import com.rstit.base.di.names.PasswordValidatorName;
import com.rstit.base.validation.EmailValidator;
import com.rstit.base.validation.NonEmptyFieldValidator;
import com.rstit.base.validation.PasswordValidator;
import com.rstit.base.validation.Validator;

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