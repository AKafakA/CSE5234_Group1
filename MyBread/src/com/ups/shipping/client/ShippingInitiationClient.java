package com.ups.shipping.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.json.JsonObject;
import javax.ws.rs.client.Entity;

public class ShippingInitiationClient {

	final String resourceUrl;
	
	public ShippingInitiationClient(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	
	public JsonObject invokeInitiateShipping(JsonObject j){
		Client client = ClientBuilder.newBuilder().build();
		client.register(ShippingInitiationClientFilter.class);
		WebTarget target = client.target(resourceUrl + "/initiation/start");
		Invocation.Builder builder = target.request("application/json");
		
		Response response = builder.post(Entity.entity(j, "application/json"));
		return response.readEntity(JsonObject.class);
	}

	public Response invokePing(){
		Client client = ClientBuilder.newBuilder().build();
		client.register(ShippingInitiationClientFilter.class);
		WebTarget target = client.target(resourceUrl + "/initiation");
		Invocation.Builder builder = target.request("text/plain");
		Response response = builder.get();
		return response; 
	}

}
