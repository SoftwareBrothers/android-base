package com.rstit.ui.auth.login;

import com.google.common.base.Strings;
import com.rstit.RxJavaTestRule;
import com.rstit.di.auth.login.TestLoginModule;
import com.rstit.di.base.DaggerTestAppComponent;
import com.rstit.validation.EmailValidator;
import com.rstit.validation.Validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */
public class LoginViewModelTest {
    @Rule
    public RxJavaTestRule mRxJavaRule = new RxJavaTestRule();

    @Inject
    protected LoginViewModel mModel;

    @Before
    public void setUp() throws Exception {
        DaggerTestAppComponent.builder()
                .build()
                .plus(new TestLoginModule())
                .inject(this);
    }

    @Test
    public void validateLogin_Success() throws Exception {
        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isValidateLogin(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mLoginError.get()), is(true));
    }

    @Test
    public void validateLogin_Error() throws Exception {
        when(mModel.mLoginValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getLoginErrorMessage()).thenReturn("error");

        assertThat(mModel.isValidateLogin(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mLoginError.get()), is(false));
    }

    @Test
    public void validatePassword_Success() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isValidatePassword(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mPasswordError.get()), is(true));
    }

    @Test
    public void validatePassword_Error() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getPasswordErrorMessage()).thenReturn("error");

        assertThat(mModel.isValidatePassword(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mPasswordError.get()), is(false));
    }

    @Test
    public void isFormValid_Success() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);
        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isInputDataValid(), is(true));
    }

    @Test
    public void isFormValid_Error() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(false);
        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isInputDataValid(), is(false));
    }

    @Test
    public void setLoginValidator_Correct() throws Exception {
        Validator validator = new EmailValidator();
        mModel.setLoginValidator(validator);

        assertThat(mModel.mLoginValidator, is(validator));
    }

    @Test
    public void setLoginValidator_Null() throws Exception {
        mModel.setLoginValidator(null);
        assertThat(mModel.isValidateLogin(), is(true));
    }

    @Test
    public void setPasswordValidator_Correct() throws Exception {
        Validator validator = new EmailValidator();
        mModel.setPasswordValidator(validator);

        assertThat(mModel.mPasswordValidator, is(validator));
    }

    @Test
    public void setPasswordValidator_Null() throws Exception {
        mModel.setPasswordValidator(null);
        assertThat(mModel.isValidatePassword(), is(true));
    }
}