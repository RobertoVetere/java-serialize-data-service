package com.holidevs.service_serialize_data.Entity;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    private String dni;

    public User(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

}
