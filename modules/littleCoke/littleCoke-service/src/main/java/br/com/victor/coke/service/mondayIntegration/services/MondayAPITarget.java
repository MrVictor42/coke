package br.com.victor.coke.service.mondayIntegration.services;

import br.com.victor.coke.service.mondayIntegration.util.AuthenticatorUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class MondayAPITarget {

    private String apiURL;
    private String token;

    public MondayAPITarget(String apiURL, String token) {
        super();
        this.apiURL = apiURL;
        this.token = token;
    }

    public MondayAPITarget(String url) {
        this.apiURL = url;
    }

    public String getApiURL() {
        return apiURL;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public Client getNewClient() {
        return ClientBuilder.newClient().register(new AuthenticatorUtil(this.token));
    }
}