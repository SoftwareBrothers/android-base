package base.ui.auth.register;

import com.google.common.base.Strings;
import base.RxJavaTestRule;
import base.di.auth.register.TestRegisterModule;
import base.di.base.DaggerTestAppComponent;
import base.validation.EmailValidator;
import base.validation.Validator;

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
 * @since 2017-05-26
 */
@SuppressWarnings("ConstantConditions")
public class RegisterViewModelTest {
    @Rule
    public RxJavaTestRule mRxJavaRule = new RxJavaTestRule();

    @Inject
    protected RegisterViewModel mModel;

    @Before
    public void setUp() throws Exception {
        DaggerTestAppComponent.builder()
                .build()
                .plus(new TestRegisterModule())
                .inject(this);
    }

    @Test
    public void validateLogin_Success() throws Exception {
        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isLoginValid(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mLoginError.get()), is(true));
    }

    @Test
    public void validateLogin_Error() throws Exception {
        when(mModel.mLoginValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getLoginErrorMessage()).thenReturn("error");

        assertThat(mModel.isLoginValid(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mLoginError.get()), is(false));
    }

    @Test
    public void validateFirstName_Success() throws Exception {
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isFirstNameValid(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mFirstNameError.get()), is(true));
    }

    @Test
    public void validateFirstName_Error() throws Exception {
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getFirstNameErrorMessage()).thenReturn("error");

        assertThat(mModel.isFirstNameValid(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mFirstNameError.get()), is(false));
    }

    @Test
    public void validateLastName_Success() throws Exception {
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isLastNameValid(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mLastNameError.get()), is(true));
    }

    @Test
    public void validateLastName_Error() throws Exception {
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getLastNameErrorMessage()).thenReturn("error");

        assertThat(mModel.isLastNameValid(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mLastNameError.get()), is(false));
    }

    @Test
    public void validatePassword_Success() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        assertThat(mModel.isPasswordValid(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mPasswordError.get()), is(true));
    }

    @Test
    public void validatePassword_Error() throws Exception {
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(false);
        when(mModel.mViewAccess.getPasswordErrorMessage()).thenReturn("error");

        assertThat(mModel.isPasswordValid(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mPasswordError.get()), is(false));
    }

    @Test
    public void validatePasswordConfirm_Success() throws Exception {
        String password = "pass123";
        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isConfirmPasswordValid(), is(true));
        assertThat(Strings.isNullOrEmpty(mModel.mConfirmPasswordError.get()), is(true));
    }

    @Test
    public void validatePasswordConfirm_Error() throws Exception {
        when(mModel.mViewAccess.getConfirmPasswordErrorMessage()).thenReturn("error");

        String password = "pass123";
        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set("");

        assertThat(mModel.isConfirmPasswordValid(), is(false));
        assertThat(Strings.isNullOrEmpty(mModel.mConfirmPasswordError.get()), is(false));
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
        assertThat(mModel.isLoginValid(), is(true));
    }

    @Test
    public void setFirstNameValidator_Correct() throws Exception {
        Validator validator = new EmailValidator();
        mModel.setFirstNameValidator(validator);

        assertThat(mModel.mFirstNameValidator, is(validator));
    }

    @Test
    public void setFirstNameValidator_Null() throws Exception {
        mModel.setFirstNameValidator(null);
        assertThat(mModel.isFirstNameValid(), is(true));
    }

    @Test
    public void setLastNameValidator_Correct() throws Exception {
        Validator validator = new EmailValidator();
        mModel.setLastNameValidator(validator);

        assertThat(mModel.mLastNameValidator, is(validator));
    }

    @Test
    public void setLastNameValidator_Null() throws Exception {
        mModel.setLastNameValidator(null);
        assertThat(mModel.isLastNameValid(), is(true));
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
        assertThat(mModel.isPasswordValid(), is(true));
    }

    @Test
    public void isFormValid_Correct() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isInputDataValid(), is(true));
    }

    @Test
    public void isFormValid_ErrorLogin() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(false);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isInputDataValid(), is(false));
    }

    @Test
    public void isFormValid_ErrorFirstName() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(false);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isInputDataValid(), is(false));
    }

    @Test
    public void isFormValid_ErrorLastName() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(false);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isInputDataValid(), is(false));
    }

    @Test
    public void isFormValid_ErrorPassword() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(false);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password);

        assertThat(mModel.isInputDataValid(), is(false));
    }

    @Test
    public void isFormValid_ErrorConfirmPassword() throws Exception {
        String password = "pass123";

        when(mModel.mLoginValidator.isValid(any())).thenReturn(true);
        when(mModel.mFirstNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mLastNameValidator.isValid(any())).thenReturn(true);
        when(mModel.mPasswordValidator.isValid(any())).thenReturn(true);

        mModel.mPassword.set(password);
        mModel.mConfirmPassword.set(password + password);

        assertThat(mModel.isInputDataValid(), is(false));
    }
}