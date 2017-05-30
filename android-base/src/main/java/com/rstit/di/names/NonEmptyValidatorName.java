package com.rstit.di.names;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @author Tomasz Trybala
 * @since 2017-05-26
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NonEmptyValidatorName {
}
