package com.cius.rest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "microservice";
	private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('READ')";
	private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('WRITE')";
	private static final String SECURED_PATTERN = "/**";

        private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",            
            "/swagger-ui/**",
            //auth
//            "/oauth/**",
            //endpoint can other project
            "/employee/find"
            
    };
        
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.sessionManagement().disable()
				.authorizeRequests()
				.antMatchers(AUTH_WHITELIST).permitAll()
				.and()
				.requestMatchers().antMatchers(SECURED_PATTERN)
				.and()
				.authorizeRequests().antMatchers(HttpMethod.POST, SECURED_PATTERN)
				.access(SECURED_WRITE_SCOPE).anyRequest()
				.access(SECURED_READ_SCOPE);
	}
}