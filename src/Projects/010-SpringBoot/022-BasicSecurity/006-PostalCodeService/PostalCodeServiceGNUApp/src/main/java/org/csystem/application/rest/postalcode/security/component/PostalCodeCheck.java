package org.csystem.application.rest.postalcode.security.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("postalCodeCheck")
public class PostalCodeCheck {
    @Value("${postalcodeapp.port.min}")
    public int min;

    @Value("${postalcodeapp.port.max:#{postalCodeCheck.min + 300}}")
    public int max;

    public boolean isValid(int postalCode)
    {
        return min <= postalCode && postalCode <= max;
    }
}
