package com.appsdeveloperblog.ws.api.ResourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected final void configure(final HttpSecurity http) throws Exception {
        // TODO Auto-generated method stub
        http.authorizeRequests() //
                .antMatchers(HttpMethod.GET, "/users/status/check") //
                .hasAuthority("SCOPE_profile") //
                .anyRequest() //
                .authenticated() //
                .and() //
                .oauth2ResourceServer() //
                .jwt(); //

    }
}
