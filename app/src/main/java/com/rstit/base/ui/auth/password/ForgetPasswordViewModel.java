package com.rstit.base.ui.auth.password;

import android.support.annotation.Nullable;

import com.rstit.base.binding.ObservableString;
import com.rstit.base.di.names.EmailValidatorName;
import com.rstit.base.validation.Validator;

import javax.inject.Inject;

/**
 * @author Tomasz Trybala
 * @since 2017-05-26
 */

public class ForgetPasswordViewModel {
    public final ObservableString mLogin = new ObservableString();
    public final ObservableString mLoginError = new ObservableString();

    @Inject
    protected ForgetPasswordViewAccess mViewAccess;

    @Inject
    @EmailValidatorName
    protected Validator mLoginValidator;

    @Inject
    public ForgetPasswordViewModel() {
    }

    protected void setLoginValidator(@Nullable Validator loginValidator) {
        mLoginValidator = loginValidator;
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
}
