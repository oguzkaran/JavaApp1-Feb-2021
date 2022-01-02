package org.csystem.application.rest.postalcode.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class PostalCodeServiceSecurityConfig extends WebSecurityConfigurerAdapter {
    private final DataSource m_dataSource;

    public PostalCodeServiceSecurityConfig(DataSource dataSource)
    {
        m_dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(m_dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.httpBasic().and().formLogin().disable();
    }
}
