package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.servlet.util.matcher.PathPatternRequestMatcher;

import com.example.demo.services.ModuleService;
//import org.springframework.security.web.util.matcher.;
import com.example.demo.services.UserService;
import com.example.demo.domain.Module;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration{
	
	@Autowired
	UserService userService;
	@Autowired 
	ModuleService moduleService;
	

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		List<Module> modules  = moduleService.getList();		

		http.authorizeHttpRequests( auth -> {
			modules.forEach(rule ->{
				//auth.requestMatchers(rule.getPath()).access(new WebExpressionAuthorizationManager("hasAnyAuthority('" + String.join( "','", rule.roles) + "')")); //Do not put prefix it works
				//auth.requestMatchers(rule.getPath()).access(new WebExpressionAuthorizationManager("hasAnyRole('" + String.join( "','", rule.roles) + "')")); // this works put the user role has prefix 'ROLE_..'
				//auth.requestMatchers(rule.getPath()).hasAnyRole(String.join( ",", rule.roles )); //This doesn't work because is is one string not array of string
				//auth.requestMatchers(rule.getPath()).hasAnyRole(rule.getRoles().toArray(new String[0])); //This shoud work but if Role is string not object
				List<String> roles = new ArrayList<String>();
				rule.getRoles().forEach(role -> roles.add(role.getName()));
				auth.requestMatchers(rule.getPath()).hasAnyRole(roles.toArray(new String[0])); //This shoud work
			});
			auth.anyRequest().authenticated();
		}).formLogin(Customizer.withDefaults());
				
		return http.build();
		
	}

	
	@Bean
	@Order(0)
	public  PasswordEncoder passwordEncoder() {
		return SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}
	
	
	//Use this if you  don't want prefix ROLE_
	@Bean
	public GrantedAuthorityDefaults grantedAuthorityDefaults() {
		
		return new GrantedAuthorityDefaults("");
		
	}
	
	
	
}
