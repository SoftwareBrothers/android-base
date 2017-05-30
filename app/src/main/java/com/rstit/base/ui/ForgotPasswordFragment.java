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
import com.rstit.base.databinding.FragmentForgotPasswordBinding;
import com.rstit.di.password.ForgotPasswordModule;

import javax.inject.Inject;

import com.rstit.ui.auth.password.ForgotPasswordViewAccess;
import com.rstit.ui.auth.password.ForgotPasswordViewModel;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class ForgotPasswordFragment extends Fragment implements ForgotPasswordViewAccess {
    @Inject
    protected ForgotPasswordViewModel mModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SampleApplication.get(getActivity()).getAppComponent()
                .plus(new ForgotPasswordModule(this))
                .inject(this);
    }

    @Override
    public @Nullable View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentForgotPasswordBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_forgot_password, null, false);
        binding.setModel(mModel);

        return binding.getRoot();
    }

    @Override
    public @NonNull String getLoginErrorMessage() {
        return getString(R.string.error_login);
    }
}
