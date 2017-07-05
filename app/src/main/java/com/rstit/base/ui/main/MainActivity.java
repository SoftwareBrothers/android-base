package com.rstit.base.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.rstit.base.R;
import com.rstit.base.SampleApplication;
import com.rstit.base.databinding.ActivityMainBinding;
import com.rstit.base.ui.ForgotPasswordFragment;
import com.rstit.base.ui.LoginFragment;
import com.rstit.base.ui.RegisterFragment;
import com.rstit.di.main.MainModule;

import javax.inject.Inject;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainActivity extends AppCompatActivity implements MainViewAccess {

    private ForgotPasswordFragment mForgotPasswordFragment;
    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;

    @Inject
    protected MainViewModel mModel;

    private void initFragments(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mForgotPasswordFragment = new ForgotPasswordFragment();
            mLoginFragment = new LoginFragment();
            mRegisterFragment = new RegisterFragment();
        } else {
            findFragments();
        }
    }

    private void findFragments() {
        ForgotPasswordFragment forgotPasswordFragment = findFragmentByTag(ForgotPasswordFragment.class);
        mForgotPasswordFragment = forgotPasswordFragment != null ? forgotPasswordFragment : new ForgotPasswordFragment();

        LoginFragment loginFragment = findFragmentByTag(LoginFragment.class);
        mLoginFragment = loginFragment != null ? loginFragment : new LoginFragment();

        RegisterFragment registerFragment = findFragmentByTag(RegisterFragment.class);
        mRegisterFragment = registerFragment != null ? registerFragment : new RegisterFragment();
    }

    @SuppressWarnings("unchecked")
    private @Nullable <T extends Fragment> T findFragmentByTag(@NonNull Class<T> cls) {
        return (T) getSupportFragmentManager().findFragmentByTag(cls.getName());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleApplication.get(this)
                .getAppComponent()
                .plus(new MainModule(this))
                .inject(this);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setModel(mModel);

        initFragments(savedInstanceState);
    }

    @Override
    public void setFragment(@NonNull MainViewModel.Type type) {
        Fragment fragment;

        switch (checkNotNull(type)) {
            case ForgotPassword:
                fragment = mForgotPasswordFragment;
                break;
            case Login:
                fragment = mLoginFragment;
                break;
            default:
            case Register:
                fragment = mRegisterFragment;
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, fragment, fragment.getClass().getName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (mModel.mIsFormVisible.get()) {
            mModel.setIsFormVisible(false);
        } else {
            super.onBackPressed();
        }
    }
}
