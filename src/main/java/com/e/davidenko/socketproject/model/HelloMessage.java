package com.e.davidenko.socketproject.model;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
public class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
