package com.example.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Service.Impl.MyUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@Service
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authprovider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider() ;
		provider.setUserDetailsService(myUserDetailService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
		
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http
        .authorizeRequests()
            .antMatchers("/**").permitAll() // Allow access to all endpoints
            .anyRequest().permitAll() // Allow all other requests as well
        .and()
        .csrf().disable() // Disable CSRF protection for simplicity
        .headers().frameOptions().disable();
		
//		http.authorizeRequests().antMatchers("/signup**","/login","/users/**").permitAll().and()
//		.authorizeRequests().antMatchers(HttpMethod.GET,"/departments/**").permitAll().and()
//		.authorizeRequests().antMatchers(HttpMethod.POST,"/departments/**").hasAnyAuthority("Admin").and()
//		.authorizeRequests().antMatchers(HttpMethod.DELETE,"/departments/**").hasAnyAuthority("Admin").and()
//		.authorizeRequests().antMatchers(HttpMethod.GET,"/employee/**").hasAnyAuthority("Admin").and()
//		.authorizeRequests().antMatchers(HttpMethod.DELETE,"/employee/**").hasAnyAuthority("Admin").and()
//		.authorizeRequests().antMatchers(HttpMethod.POST,"/employee/**").hasAnyAuthority("Admin").anyRequest().authenticated().and().formLogin().permitAll().and().httpBasic();
//		
	}

}
