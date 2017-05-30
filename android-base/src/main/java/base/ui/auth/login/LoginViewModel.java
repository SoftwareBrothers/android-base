package base.ui.auth.login;

import android.support.annotation.Nullable;

import base.binding.ObservableString;
import base.di.names.EmailValidatorName;
import base.di.names.PasswordValidatorName;
import base.ui.base.model.BaseViewModel;
import base.validation.Validator;

import javax.inject.Inject;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public class LoginViewModel extends BaseViewModel {
    public final ObservableString mLogin = new ObservableString();
    public final ObservableString mLoginError = new ObservableString();
    public final ObservableString mPassword = new ObservableString();
    public final ObservableString mPasswordError = new ObservableString();

    @Inject
    protected LoginViewAccess mViewAccess;

    @Inject
    @EmailValidatorName
    protected Validator mLoginValidator;

    @Inject
    @PasswordValidatorName
    protected Validator mPasswordValidator;

    @Inject
    public LoginViewModel() {
    }

    protected void setLoginValidator(@Nullable Validator loginValidator) {
        mLoginValidator = loginValidator;
    }

    protected void setPasswordValidator(@Nullable Validator passwordValidator) {
        mPasswordValidator = passwordValidator;
    }

    protected boolean isValidateLogin() {
        boolean valid = true;

        if (mLoginValidator != null && !mLoginValidator.isValid(mLogin.get())) {
            mLoginError.set(mViewAccess.getLoginErrorMessage());
            valid = false;
        } else {
            mLoginError.set(null);
        }

        return valid;
    }

    protected boolean isValidatePassword() {
        boolean valid = true;

        if (mPasswordValidator != null && !mPasswordValidator.isValid(mPassword.get())) {
            mPasswordError.set(mViewAccess.getPasswordErrorMessage());
            valid = false;
        } else {
            mPasswordError.set(null);
        }

        return valid;
    }

    public boolean isInputDataValid() {
        return isValidateLogin() && isValidatePassword();
    }
}
