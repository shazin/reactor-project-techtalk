package com.github.shazin.reactorprojecttechtalk.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class TaxiLocationEvent {

    private String id;

    private String type;

    private Location location;

    public TaxiLocationEvent() {}

    @JsonCreator
    public TaxiLocationEvent(@JsonProperty("id") String id, @JsonProperty("type") String type, @JsonProperty("location") Location location) {
        this.id = id;
        this.type = type;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiLocationEvent that = (TaxiLocationEvent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, location);
    }

    @Override
    public String toString() {
        return "TaxiLocationEvent{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", location=" + location +
                '}';
    }
}
