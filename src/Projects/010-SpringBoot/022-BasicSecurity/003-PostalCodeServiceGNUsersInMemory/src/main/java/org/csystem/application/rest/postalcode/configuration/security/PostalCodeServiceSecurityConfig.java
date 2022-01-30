package org.csystem.application.rest.postalcode.configuration.security;

import org.csystem.util.Console;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Configuration
public class PostalCodeServiceSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Collection<UserDetails> m_users;


    public PostalCodeServiceSecurityConfig(Collection<UserDetails> users)
    {
        m_users = users;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        var imo = auth.inMemoryAuthentication();

        for (var user : m_users)
            imo.withUser(user);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
}
