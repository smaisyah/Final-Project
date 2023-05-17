package com.mii.metrodata.clientappsima.clientappsima.confiq;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/css/**","/js/**").permitAll()
                // .antMatchers("/login").permitAll()
                // .antMatchers("/register").permitAll()
                .anyRequest()
                // .authenticated()
                // .and()
                // .formLogin()
                // .loginPage("/login")
                // .successForwardUrl("/dashboard")
                // .failureForwardUrl("/login?error=true")
                // .permitAll()
                // .and()
                // .logout()
                // .logoutUrl("/logout")
                .permitAll();
    }


}