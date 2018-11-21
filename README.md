# Android Base

The project contains the most used modules in Android applications developed by RST Software House.

Getting started
----------
We are using the most common libraries and approaches available in the Android community like [DataBinding](https://developer.android.com/topic/libraries/data-binding/index.html) or [Dagger 2](https://google.github.io/dagger/).
Applications are written based on MVVM architecture - you can read more about this pattern [here](https://msdn.microsoft.com/en-us/library/hh848246.aspx)

Examples
--------

ViewModel and ViewAccess classes are able to extend, you can prepare them in your individual way.
Every class from View layer has to implement a ViewAccess class used in injected ViewModel.

```java
public class LoginViewModel extends BaseViewModel {

    @Inject
    protected LoginViewAccess mViewAccess;

    @Inject
    public LoginViewModel() {
    }

    //{...}
}
```

```java
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
```

Prepare a module and a component to use your classes through Dagger:

```java
@Module
public class LoginModule {
    private LoginFragment mLoginFragment;

    public LoginModule(@NonNull LoginFragment loginFragment) {
        mLoginFragment = checkNotNull(loginFragment);
    }

    @Provides
    @FragmentScope
    public LoginFragment providesLoginFragment() {
        return mLoginFragment;
    }

    @Provides
    @FragmentScope
    public LoginViewAccess providesLoginViewAccess(@NonNull LoginFragment loginFragment) {
        return loginFragment;
    }
}
```

```java
@FragmentScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    LoginFragment inject(LoginFragment loginFragment);
}
```

Finally add your component to the main application component:

```java
public interface AppComponent {
    LoginComponent plus(LoginModule module);
}
```

Please follow the sample application if you want to check how it looks in practice.

Installing
----------

Versions are available on bintray jcenter / maven central.

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'com.rst-it:android-base:1.0.2'
}
```


## License

android-base is Copyright © 2018 SoftwareBrothers.co. It is free software, and may be redistributed under the terms specified in the [LICENSE](LICENSE.md) file.

## About SoftwareBrothers.co

<img src="https://softwarebrothers.co/assets/images/software-brothers-logo-full.svg" width=240>


We’re an open, friendly team that helps clients from all over the world to transform their businesses and create astonishing products.

* We are available to [hire](https://softwarebrothers.co/contact).
* If you want to work for us - checkout the [career page](https://softwarebrothers.co/career).
