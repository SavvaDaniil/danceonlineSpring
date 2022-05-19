package com.dancestudioSpring.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dancestudioSpring.Filter.JwtAdminAuthenticationFilter;
import com.dancestudioSpring.Service.AdminService;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter  {

	//implements WebMvcConfigurer
	
	//@Autowired
	//private DataSource dataSource;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	JwtAdminAuthenticationFilter jwtAdminAuthenticationFilter;
	
	/*
	@Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/public/**").addResourceLocations("file:public/");
        
        //registry.addResourceHandler("/private/**").addResourceLocations("file:private/");
        
        //registry.addResourceHandler("/video/**").addResourceLocations("file:video/");
    }
    */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		String[] staticResources  =  {
		        "/favicon.ico",
		        "/public/**",
		    };
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
	            .antMatchers(staticResources).permitAll()
				.anyRequest().hasRole("ADMIN")
			.and()
				.formLogin()
			//	.defaultSuccessUrl("/account", true)
			//	.loginPage("/login")
			//	.permitAll()
			.and()
		        .rememberMe()
	            .alwaysRemember(true)
	            .tokenValiditySeconds(86400 * 30)
	            .rememberMeCookieName("remember")//mouni
	            .key("fkYdo39TGd8#%ytjfsFdskgs")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login")
				.permitAll();
		*/
		http
			.csrf().disable()
			.cors().disable()
		.authorizeRequests()
			.antMatchers("/","/api/admin/login").permitAll()
			.anyRequest().authenticated()
		.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtAdminAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub

		auth.userDetailsService(adminService);
		
		
		/*
		auth.jdbcAuthentication()
			.dataSource(dataSource)
			//.passwordEncoder(NoOpPasswordEncoder.getInstance())
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("SELECT username, password, active FROM admin WHERE username = ?");
			//.authoritiesByUsernameQuery("SELECT admin.username, admin.roles FROM admin "
			//		+ "INNER JOIN user_role ON admin.id = admin_role.id_of_user WHERE admin.username = ?");
			
		*/
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
