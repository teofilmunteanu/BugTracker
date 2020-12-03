package com.teofilmunteanu.BugTracker.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private DataSource dataSource;
	
	/*At log in, it creates the queries that return the user's data(email,password,role) from the database*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("SELECT email AS principal, password AS credentails, true FROM user WHERE email=?")
		.authoritiesByUsernameQuery("SELECT user_email AS principal, role_name AS role FROM user_roles WHERE user_email=?")
		.passwordEncoder(passwordEncoder()).rolePrefix("ROLE_"); 
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/*Authorizes requests depending on the user*/
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic().disable();
		http.authorizeRequests().antMatchers("/", "/register", "/login", "/css/**", "/webjars/**").permitAll() 
		.antMatchers("/bugs").hasAnyRole("DEVELOPER, PROJECT_MANAGER")
		.antMatchers("/users", "/addBug", "/teams", "/projects").hasRole("PROJECT_MANAGER")
		.and().formLogin().loginPage("/login").permitAll()
		.defaultSuccessUrl("/bugs").and().logout().logoutSuccessUrl("/login");
	}
}
