package com.packtpub.microservices.openliberty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author mertcaliskan
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Location implements Serializable {

    String name;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
