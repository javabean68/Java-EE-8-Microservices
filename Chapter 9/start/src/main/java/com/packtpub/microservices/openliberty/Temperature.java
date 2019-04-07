package com.packtpub.microservices.openliberty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Temperature {

    private Double temperature;
    private TemperatureScale temperatureScale;

    public Double getTemperature() {
        return temperature;
    }

    /**
     * @param temperature Scalar value representing the actual temperature
     */
    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public TemperatureScale getTemperatureScale() {
        return temperatureScale;
    }

    /**
     * @param temperatureScale Scale the temperature value is on
     */
    public void setTemperatureScale(TemperatureScale temperatureScale) {
        this.temperatureScale = temperatureScale;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "temperature=" + temperature +
                ", temperatureScale=" + temperatureScale +
                '}';
    }
}