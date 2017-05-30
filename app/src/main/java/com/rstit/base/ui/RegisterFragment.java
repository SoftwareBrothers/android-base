package com.rstit.base.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import base.ui.auth.register.RegisterViewAccess;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class RegisterFragment extends Fragment implements RegisterViewAccess{
    @NonNull @Override public String getLoginErrorMessage() {
        return null;
    }

    @NonNull @Override public String getFirstNameErrorMessage() {
        return null;
    }

    @NonNull @Override public String getLastNameErrorMessage() {
        return null;
    }

    @NonNull @Override public String getPasswordErrorMessage() {
        return null;
    }

    @NonNull @Override public String getConfirmPasswordErrorMessage() {
        return null;
    }
}
