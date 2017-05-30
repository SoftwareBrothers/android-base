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
import com.rstit.base.databinding.FragmentRegisterBinding;
import com.rstit.base.di.register.RegisterModule;

import javax.inject.Inject;

import base.ui.auth.register.RegisterViewAccess;
import base.ui.auth.register.RegisterViewModel;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class RegisterFragment extends Fragment implements RegisterViewAccess {
    @Inject
    protected RegisterViewModel mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleApplication.get(getActivity()).getAppComponent()
                .plus(new RegisterModule(this))
                .inject(this);
    }

    @Override
    public @Nullable View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentRegisterBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, null, false);
        binding.setModel(mModel);

        return binding.getRoot();
    }

    @Override
    public @NonNull String getLoginErrorMessage() {
        return getString(R.string.error_login);
    }

    @Override
    public @NonNull String getFirstNameErrorMessage() {
        return getString(R.string.error_first_name);
    }

    @Override
    public @NonNull String getLastNameErrorMessage() {
        return getString(R.string.error_last_name);
    }

    @Override
    public @NonNull String getPasswordErrorMessage() {
        return getString(R.string.error_password);
    }

    @Override
    public @NonNull String getConfirmPasswordErrorMessage() {
        return getString(R.string.error_confirm_password);
    }
}
