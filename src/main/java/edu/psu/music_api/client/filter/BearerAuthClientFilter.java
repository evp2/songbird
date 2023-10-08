package edu.psu.music_api.client.filter;


import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;

public class BearerAuthClientFilter implements ClientRequestFilter {

    private final String token;

    public BearerAuthClientFilter(String token) {
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext requestContext) {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        final String bearerAuthentication = "Bearer " + this.token;
        headers.add("Authorization", bearerAuthentication);
    }
}
