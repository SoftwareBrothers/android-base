package com.rstit.base.binding;

import android.databinding.ObservableField;
import android.support.annotation.Nullable;

/**
 * @author Tomasz Trybala
 * @since 2017-05-25
 */

public class ObservableString extends ObservableField<String> {
    public ObservableString() {
        super();
    }

    public ObservableString(@Nullable String text) {
        super(text);
    }
}
