package com.packtpub.microservices.openliberty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceResponse {
    long processingTime;
    List<Forecast> forecasts = new ArrayList<>();

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setProcessingTime(long l) {
        processingTime = l;
    }
}