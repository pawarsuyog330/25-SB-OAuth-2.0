package com.ashokit.oauth.api;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApi {

	@GetMapping("/hello")
	public String sayHello(OAuth2AuthenticationToken token)
	{
		System.out.println(token.getPrincipal().getName());
		return "Hello...";
	}
}
