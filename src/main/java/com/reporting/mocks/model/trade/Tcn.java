package com.reporting.mocks.model.trade;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Objects;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tcn tcn = (Tcn) obj;
        return this.id.equals(tcn.getId()) &&
                this.version == tcn.getVersion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.version);
    }

    @Override
    public String toString() {
        return this.id + "v" + this.version;
    }
}
