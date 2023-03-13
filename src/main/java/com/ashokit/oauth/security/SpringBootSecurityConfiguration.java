package com.ashokit.oauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login();
	}
	
	private ClientRegistration clientRegistration()
	{
		return CommonOAuth2Provider.GITHUB.getBuilder("github")
								   .clientId("4a203a332524b5a098e6")
								   .clientSecret("41af1797e55beb1562fe92661176951da86692a9")
								   .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
								   .build();
	}
	
	@Bean
	 public ClientRegistrationRepository clientRepository()
	 {
		ClientRegistration reg=clientRegistration();
		return new InMemoryClientRegistrationRepository(reg);
	 }
}
