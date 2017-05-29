package base.di.base;

import android.support.annotation.NonNull;

import base.di.names.EmailValidatorName;
import base.di.names.NonEmptyValidatorName;
import base.di.names.PasswordValidatorName;
import base.validation.EmailValidator;
import base.validation.NonEmptyFieldValidator;
import base.validation.PasswordValidator;
import base.validation.Validator;

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