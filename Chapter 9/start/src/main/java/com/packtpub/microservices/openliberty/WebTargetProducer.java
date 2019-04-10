package com.packtpub.microservices.openliberty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@ApplicationScoped
public class WebTargetProducer {
    private Client client;

    @PostConstruct
    public void postConstruct() {
        this.client = ClientBuilder.newClient();
    }

    @Produces
    public WebTarget produceLocationWebTarget() {
        return client.target("http://localhost:9080").path("smartcity").path("location");
    }
}