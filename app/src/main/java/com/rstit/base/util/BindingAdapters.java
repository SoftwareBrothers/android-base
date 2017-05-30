package com.rstit.base.util;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * @author Tomasz Trybala
 * @since 2017-05-30
 */

public class BindingAdapters {
    @BindingAdapter("visibleIf")
    public static void setViewVisibility(@NonNull View view, boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
