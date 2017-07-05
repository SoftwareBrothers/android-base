![rstit](http://rst-it.com/assets/logo-5148e54c49c211b40d170a5450634799.png)
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


License
-------

    Copyright (C) 2017 rst-it.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
