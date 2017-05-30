package com.rstit.base.ui.main;

import android.support.annotation.NonNull;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public interface MainViewAccess {
    void setFragment(@NonNull MainViewModel.Type type);
}
