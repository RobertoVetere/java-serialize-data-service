package com.holidevs.service_serialize_data.Entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    private String DNI;

    public User(String name, String DNI) {
        this.name = name;
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}
