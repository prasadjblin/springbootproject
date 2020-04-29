package com.venkat.productservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	/* 
	 * used bcrypt password hashing for plain text - password
	 * can be used {noop}password - for plain text without encryption
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user").password("$2a$05$sdwRpwQ0YLUgQ4m/La.hgeCyGnoTxymyz9ZAzu7H0Sb4L/WECT0Q2").roles("USER")
		.and()
		.withUser("admin").password("$2a$05$sdwRpwQ0YLUgQ4m/La.hgeCyGnoTxymyz9ZAzu7H0Sb4L/WECT0Q2").roles("USER", "ADMIN");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/getconfigdetails").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/api/getproductdetails").hasAnyRole("ADMIN","USER")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
