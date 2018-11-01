package com.ups.shipping.client;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ShippingInitiationClientFilter implements ClientRequestFilter, ClientResponseFilter {
	
	public ShippingInitiationClientFilter() {
	}
	
	@Override
	public void filter(ClientRequestContext request) throws IOException {
		// TODO: Implement client request behavior.
	}

	@Override
	public void filter(ClientRequestContext request, ClientResponseContext response) throws IOException {
		// TODO: Implement client response behavior.
	}
}
