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


//import org.springframework.security.web.util.matcher.;
import com.example.demo.services.UserService;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration{
	
	@Autowired
	UserService userService;
	/*
	//Static 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests( auth -> auth
				.requestMatchers("/public/**").permitAll() // allow public access
				.requestMatchers("/home/**").permitAll() //allow public access
				.requestMatchers("/Products/**").hasAnyRole("Admins") //allow only admin roles
				.anyRequest().authenticated() //authenticate all other resource
				)
		/*.formLogin(frm->frm.loginPage("/login")
						.defaultSuccessUrl("/home", true)
						.failureUrl("/login?error=true")
						.permitAll()
						);*/
	/*	.formLogin(Customizer.withDefaults());
				
		return http.build();
		
	}*/
	


	
	//Dynamic
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//PathPatternRequestMatcher matcher = new PathPatternRequestMatcher(null, matcher)
		
		List<DynaRules> dynaRules = new ArrayList<DynaRules>();
		
		dynaRules.add(new DynaRules("/admin/**",new ArrayList<String>(Arrays.asList("Admins","Users","Operators"))));
		dynaRules.add(new DynaRules("/Products/**",new ArrayList<String>(Arrays.asList("Admins","Users"))));
		dynaRules.add(new DynaRules("/Categories/**",new ArrayList<String>(Arrays.asList("Users","Operators"))));
		//String[] roles = {"Users","Operators"};
		
		
	
		
//		http.authorizeHttpRequests( auth -> auth
//			.requestMatchers("/home").permitAll()
//			.anyRequest().authenticated()
//			).formLogin(
//					/*frm->frm
//				.loginPage("/login")
//				.defaultSuccessUrl("/home")
//				.failureUrl("/login?error=true")
//				.permitAll()*/
//					
//					Customizer.withDefaults()
//			).logout(frm -> frm
//					.logoutUrl("/logout")
//					);
		
			

		http.authorizeHttpRequests( auth -> {
			dynaRules.forEach(rule ->{
				//auth.requestMatchers(rule.getPath()).access(new WebExpressionAuthorizationManager("hasAnyAuthority('" + String.join( "','", rule.roles) + "')")); //Do not put prefix it works
				//auth.requestMatchers(rule.getPath()).access(new WebExpressionAuthorizationManager("hasAnyRole('" + String.join( "','", rule.roles) + "')")); // this works put the user role has prefix 'ROLE_..'
				//auth.requestMatchers(rule.getPath()).hasAnyRole(String.join( ",", rule.roles )); //This doesn't work because is is one string not array of string
				auth.requestMatchers(rule.getPath()).hasAnyRole(rule.getRoles().toArray(new String[0])); //This shoud work
			});
			auth.anyRequest().authenticated();
		}).formLogin(Customizer.withDefaults());
				
		return http.build();
		
	}

	
	
	
	class DynaRules{
		
		public DynaRules(String path, List<String> roles) {
			this.path=path;
			this.roles=roles;
			
		}
		String path;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public List<String> getRoles() {
			return roles;
		}
		public void setRoles(List<String> roles) {
			this.roles = roles;
		}
		List<String> roles;
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
