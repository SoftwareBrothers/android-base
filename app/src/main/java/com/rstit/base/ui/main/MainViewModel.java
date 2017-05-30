package com.rstit.base.ui.main;

import android.databinding.ObservableBoolean;

import javax.inject.Inject;

import base.ui.base.model.BaseViewModel;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class MainViewModel extends BaseViewModel {
    public enum Type {
        Login,
        Register,
        ForgotPassword
    }

    public final ObservableBoolean mIsFormVisible = new ObservableBoolean();

    @Inject
    protected MainViewAccess mViewAccess;

    @Inject
    public MainViewModel() {
    }

    public void openLogin() {
        mViewAccess.setFragment(Type.Login);
    }

    public void openRegister() {
        mViewAccess.setFragment(Type.Register);
    }

    public void openForgot() {
        mViewAccess.setFragment(Type.ForgotPassword);
    }
}
