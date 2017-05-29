package base.ui.auth.register;

import android.support.annotation.NonNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public interface RegisterViewAccess {
    @NonNull String getLoginErrorMessage();

    @NonNull String getFirstNameErrorMessage();

    @NonNull String getLastNameErrorMessage();

    @NonNull String getPasswordErrorMessage();

    @NonNull String getConfirmPasswordErrorMessage();
}
