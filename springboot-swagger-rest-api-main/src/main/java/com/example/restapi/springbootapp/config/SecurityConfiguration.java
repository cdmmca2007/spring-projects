package com.example.restapi.springbootapp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	                .authorizeRequests()
	                .antMatchers("/swagger/test","/swagger-ui/index.html","/api-docs").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .httpBasic();
        }

}
