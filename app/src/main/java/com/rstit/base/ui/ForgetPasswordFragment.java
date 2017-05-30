package com.rstit.base.ui;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import base.ui.auth.password.ForgotPasswordViewAccess;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class ForgetPasswordFragment extends Fragment implements ForgotPasswordViewAccess {
    @Override
    public @NonNull String getLoginErrorMessage() {
        return null;
    }
}
