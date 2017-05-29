package base.ui.auth.register;

import android.support.annotation.Nullable;

import com.google.common.base.Strings;
import base.binding.ObservableString;
import base.di.names.EmailValidatorName;
import base.di.names.NonEmptyValidatorName;
import base.di.names.PasswordValidatorName;
import base.ui.base.model.BaseViewModel;
import base.validation.Validator;

import javax.inject.Inject;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public class RegisterViewModel extends BaseViewModel {
    public final ObservableString mLogin = new ObservableString();
    public final ObservableString mFirstName = new ObservableString();
    public final ObservableString mLastName = new ObservableString();
    public final ObservableString mPassword = new ObservableString();
    public final ObservableString mConfirmPassword = new ObservableString();

    public final ObservableString mLoginError = new ObservableString();
    public final ObservableString mFirstNameError = new ObservableString();
    public final ObservableString mLastNameError = new ObservableString();
    public final ObservableString mPasswordError = new ObservableString();
    public final ObservableString mConfirmPasswordError = new ObservableString();

    @Inject
    protected RegisterViewAccess mViewAccess;

    @Inject
    @EmailValidatorName
    protected Validator mLoginValidator;

    @Inject
    @NonEmptyValidatorName
    protected Validator mFirstNameValidator;

    @Inject
    @NonEmptyValidatorName
    protected Validator mLastNameValidator;

    @Inject
    @PasswordValidatorName
    protected Validator mPasswordValidator;

    @Inject
    public RegisterViewModel() {
    }

    protected void setLoginValidator(@Nullable Validator validator) {
        mLoginValidator = validator;
    }

    protected void setFirstNameValidator(@Nullable Validator validator) {
        mFirstNameValidator = validator;
    }

    protected void setLastNameValidator(@Nullable Validator validator) {
        mLastNameValidator = validator;
    }

    protected void setPasswordValidator(@Nullable Validator validator) {
        mPasswordValidator = validator;
    }

    protected boolean isLoginValid() {
        boolean valid = true;

        if (mLoginValidator != null && !mLoginValidator.isValid(mLogin.get())) {
            mLoginError.set(mViewAccess.getLoginErrorMessage());
            valid = false;
        } else {
            mLoginError.set(null);
        }

        return valid;
    }

    protected boolean isFirstNameValid() {
        boolean valid = true;

        if (mFirstNameValidator != null && !mFirstNameValidator.isValid(mFirstName.get())) {
            mFirstNameError.set(mViewAccess.getFirstNameErrorMessage());
            valid = false;
        } else {
            mFirstNameError.set(null);
        }

        return valid;
    }

    protected boolean isLastNameValid() {
        boolean valid = true;

        if (mLastNameValidator != null && !mLastNameValidator.isValid(mLastName.get())) {
            mLastNameError.set(mViewAccess.getLastNameErrorMessage());
            valid = false;
        } else {
            mLastNameError.set(null);
        }

        return valid;
    }

    protected boolean isPasswordValid() {
        boolean valid = true;

        if (mPasswordValidator != null && !mPasswordValidator.isValid(mPassword.get())) {
            mPasswordError.set(mViewAccess.getPasswordErrorMessage());
            valid = false;
        } else {
            mPasswordError.set(null);
        }

        return valid;
    }

    protected boolean isConfirmPasswordValid() {
        boolean valid = true;

        if (!Strings.isNullOrEmpty(mPassword.get()) && !Strings.isNullOrEmpty(mConfirmPassword.get()) &&
                mPassword.get().equals(mConfirmPassword.get())) {
            mConfirmPasswordError.set(null);
        } else {
            mConfirmPasswordError.set(mViewAccess.getConfirmPasswordErrorMessage());
            valid = false;
        }

        return valid;
    }

    protected boolean isInputDataValid() {
        return isLoginValid() && isFirstNameValid() && isLastNameValid() && isPasswordValid() &&
                isConfirmPasswordValid();
    }
}
