package base.di.base;

import android.support.annotation.NonNull;



import javax.inject.Singleton;

import base.di.names.EmailValidatorName;
import base.di.names.NonEmptyValidatorName;
import base.di.names.PasswordValidatorName;
import base.validation.EmailValidator;
import base.validation.NonEmptyFieldValidator;
import base.validation.PasswordValidator;
import base.validation.Validator;
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