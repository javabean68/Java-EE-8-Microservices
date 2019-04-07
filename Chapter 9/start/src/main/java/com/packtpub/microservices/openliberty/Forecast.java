package com.packtpub.microservices.openliberty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Forecast {

    private Location location;
    private Temperature temperature;

    public Forecast(Location location, Temperature temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public Forecast(){
    }

    public Location getLocation() {
        return location;
    }
    public Temperature getTemperature() {
        return temperature;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
    
}
