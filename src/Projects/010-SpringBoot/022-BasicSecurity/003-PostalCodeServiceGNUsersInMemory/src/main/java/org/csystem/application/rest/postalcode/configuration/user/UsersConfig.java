package org.csystem.application.rest.postalcode.configuration.user;

import org.csystem.util.Console;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class UsersConfig {

    @Bean
    public Collection<UserDetails> getUsers()
    {

        var adminUser = User.withDefaultPasswordEncoder()
                .username("bora")
                .password("1234")
                .authorities("ADMIN", "USER")
                .build();

        var normalUser = User.withDefaultPasswordEncoder()
                .username("coskun")
                .password("12345")
                .authorities("USER")
                .build();

        var disabledUser = User.withDefaultPasswordEncoder()
                .username("oguz")
                .password("123")
                .authorities("ADMIN")
                .disabled(true)
                .build();

        return new ArrayList<>() {{add(adminUser); add(normalUser); add(disabledUser);}};
    }
}
