package com.packtpub.microservices.openliberty;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/forecast")
public class ForecastResource {

    private static final String BASE_URI = "http://localhost:9080/smartcity" ;

    @PostConstruct
    public void initWebTargets() {
        //locationTarget = ClientBuilder.newClient().target(BASE_URI).path("location");
        temperatureTarget = ClientBuilder.newClient().target(BASE_URI).path("temperature/{city}");
    }

    @Inject
    public WebTargetProducer producer;

    //@Uri("temperature/{city}")
    private WebTarget temperatureTarget;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLocationsWithTemperature() {
        long startTime = System.currentTimeMillis();
        ServiceResponse response = new ServiceResponse();

        List<Location> locations = producer.produceLocationWebTarget().request()
                .get(new GenericType<List<Location>>() {});

        locations.forEach(location -> {
            Temperature temperature = temperatureTarget
                    .resolveTemplate("city", location.getName())
                    .request()
                    .get(Temperature.class);

            response.getForecasts()
                    .add(new Forecast(location, temperature));
        });
        
        long endTime = System.currentTimeMillis();
        response.setProcessingTime(endTime - startTime);

        return Response.ok(response).build();
    }
}