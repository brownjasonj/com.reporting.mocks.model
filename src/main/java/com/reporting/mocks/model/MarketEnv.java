package com.reporting.mocks.model;

import com.reporting.mocks.model.id.MarketEnvId;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class MarketEnv {
    protected Instant timeStamp;
    protected MarketEnvId marketEnvId;
    protected Instant asOf;
    protected PricingGroup pricingGroup;
    protected DataMarkerType type;

    public MarketEnv(PricingGroup pricingGroup, DataMarkerType type, int dayAdvance) {
        this.timeStamp = Instant.now(Clock.system(ZoneOffset.UTC));
        this.marketEnvId= new MarketEnvId(pricingGroup.getName());
        this.asOf = Clock.system(ZoneOffset.UTC).instant().plus(dayAdvance, ChronoUnit.DAYS);
        this.pricingGroup = pricingGroup;
        this.type = type;
    }
    public MarketEnv(PricingGroup pricingGroup, DataMarkerType type) {
        this(pricingGroup, type, 0);
    }

    public MarketEnvId getId() { return this.marketEnvId; }

    public Instant getAsOf() {
        return asOf;
    }

    public PricingGroup getPricingGroup() {
        return pricingGroup;
    }

    public DataMarkerType getType() {
        return type;
    }

    public Instant getTimeStamp() {
        return this.timeStamp;
    }

    public boolean equal(MarketEnv marketEnv) {
        return this.marketEnvId.getId().compareTo(marketEnv.getId().getId()) == 0;
    }
}
