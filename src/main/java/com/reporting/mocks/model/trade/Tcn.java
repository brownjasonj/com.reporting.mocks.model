package com.reporting.mocks.model.trade;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

public class Tcn {
    protected Instant timeStamp;
    protected UUID id;
    protected int version;

    public Tcn() {
        this.timeStamp = Instant.now(Clock.system(ZoneOffset.UTC));
        this.id = UUID.randomUUID();
        this.version = 0;
    }

    public Tcn(UUID id, int version) {
        this.timeStamp = Instant.now(Clock.system(ZoneOffset.UTC));
        this.id = id;
        this.version = version;
    }

    protected Tcn(Tcn tcn) {
        this(tcn.id, tcn.version + 1);
    }

    public Tcn createNewVersion() {
        return new Tcn(this);
    }

    public UUID getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public Instant getTimeStamp() {
        return this.timeStamp;
    }
    
    @Override
    public String toString() {
        return this.id + "v" + this.version;
    }
}
