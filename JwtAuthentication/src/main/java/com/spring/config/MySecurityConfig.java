package com.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter  {


	
@Autowired
private UserDetailServiceImpl  userservice ;
@Autowired
private JwtAuthenticationFilter jwtFilter;

@Autowired
private JwtAuthenticationEntryPoint entryPoint;

@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}
@Bean
public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
}
/*
@Bean
public BCryptPasswordEncoder passwordEncoder()
{
	return new BCryptPasswordEncoder() ;
}

  @Bean
public DaoAuthenticationProvider authenticationProvider()
{
	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider() ;
	daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
	return daoAuthenticationProvider ;  
	
} */

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userservice) ;
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	http
	  .csrf().disable().cors().disable().authorizeRequests().antMatchers("/token").permitAll().anyRequest().authenticated().and()
	  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	  .and()
      .exceptionHandling().authenticationEntryPoint(entryPoint);
	
}


}