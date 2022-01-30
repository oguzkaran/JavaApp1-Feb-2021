package org.csystem.application.rest.postalcode.security.annotation;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasRole('VIEWER') and @postalCodeCheck.isValid(#code)")
public @interface PrePostalCode {
    String value();
}
