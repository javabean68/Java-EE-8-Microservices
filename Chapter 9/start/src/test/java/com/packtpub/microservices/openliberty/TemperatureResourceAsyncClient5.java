package com.packtpub.microservices.openliberty;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.reactivex.Flowable;
import org.glassfish.jersey.client.rx.rxjava2.RxFlowableInvoker;
import org.glassfish.jersey.client.rx.rxjava2.RxFlowableInvokerProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TemperatureResourceAsyncClient5 {

    public static void main(String... args) {

        Client client = ClientBuilder.newClient()
                .register(RxFlowableInvokerProvider.class).register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://localhost:9080/smartcity/forecast");

        Invocation.Builder builder = target.request();
        Flowable<Response> flowable = builder
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .rx(RxFlowableInvoker.class)
                .get();

        flowable.subscribe(res -> {
            ServiceResponse serviceResponse = res.readEntity(ServiceResponse.class);
            serviceResponse.getForecasts().stream().forEach(f -> {
                System.out.print(f.getLocation().getName());
                System.out.println( ": " + f.getTemperature().getTemperature() + " " + f.getTemperature().getTemperatureScale());
            });
        });

        new Thread(() -> {
            try {
                for (int seconds = 3; seconds > 0; seconds--) {
                    System.out.println(seconds + " seconds left");
                    Thread.sleep(1000);
                }
                System.out.println("Finished!");
                client.close();
            }
            catch (Exception ignored) {}
        }).start();
    }
}