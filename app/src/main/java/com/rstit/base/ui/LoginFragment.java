package com.rstit.base.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rstit.base.R;
import com.rstit.base.SampleApplication;
import com.rstit.base.databinding.FragmentLoginBinding;
import com.rstit.base.di.login.LoginModule;

import javax.inject.Inject;

import base.ui.auth.login.LoginViewAccess;
import base.ui.auth.login.LoginViewModel;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class LoginFragment extends Fragment implements LoginViewAccess {
    @Inject
    protected LoginViewModel mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleApplication.get(getActivity()).getAppComponent()
                .plus(new LoginModule(this))
                .inject(this);
    }

    @Override
    public @Nullable View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, null, false);
        binding.setModel(mModel);

        return binding.getRoot();
    }

    @Override
    public @NonNull String getLoginErrorMessage() {
        return getString(R.string.error_login);
    }

    @Override
    public @NonNull String getPasswordErrorMessage() {
        return getString(R.string.error_password);
    }
}
