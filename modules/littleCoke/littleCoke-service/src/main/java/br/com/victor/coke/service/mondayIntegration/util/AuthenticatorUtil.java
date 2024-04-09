package br.com.victor.coke.service.mondayIntegration.util;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;

public class AuthenticatorUtil implements ClientRequestFilter {
	
	private String token;
	
	public AuthenticatorUtil(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void filter(ClientRequestContext requestContext) throws IOException {
		MultivaluedMap<String, Object> headers = requestContext.getHeaders();

        headers.add("Accept", "application/json");
		headers.add("Authorization", this.token	);
		headers.add("API-Version", "2023-10");
		headers.addAll("Access-Control-Allow-Origin", "*");
	}
}