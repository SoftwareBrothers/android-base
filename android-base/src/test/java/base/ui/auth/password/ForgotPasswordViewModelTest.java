package base.ui.auth.password;

import com.google.common.base.Strings;
import base.RxJavaTestRule;
import base.di.auth.password.TestForgetPasswordModule;
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
public class ForgotPasswordViewModelTest {
    @Rule
    public RxJavaTestRule mRxJavaRule = new RxJavaTestRule();

    @Inject
    protected ForgotPasswordViewModel mModel;

    @Before
    public void setUp() throws Exception {
        DaggerTestAppComponent.builder()
                .build()
                .plus(new TestForgetPasswordModule())
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
}