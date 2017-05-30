package com.rstit.ui.auth.login;

import android.support.annotation.NonNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public interface LoginViewAccess {
    @NonNull String getLoginErrorMessage();

    @NonNull String getPasswordErrorMessage();
}
