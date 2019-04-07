package com.reporting.mocks.model.id;

import java.util.UUID;

public abstract class Id {
    protected String locator;
    protected String uri;
    protected UUID id;

    public Id() {

    }

    public Id(String locator, UUID id) {
        if (id == null)
            this.id = UUID.randomUUID();
        else
            this.id = id;
        this.uri = locator +  "/" + this.getId();
        this.locator = locator;
    }

    public Id(String locator) {
        this(locator, UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getLocator() { return locator; }

    public String toString() { return id.toString(); }

}
