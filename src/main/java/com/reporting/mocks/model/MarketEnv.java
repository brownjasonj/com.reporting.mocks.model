package com.reporting.mocks.model;

import com.reporting.mocks.model.id.MarketEnvId;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class MarketEnv {
    protected Date timeStamp;
    protected MarketEnvId marketEnvId;
    protected Date asOf;
    protected PricingGroup pricingGroup;
    protected DataMarkerType type;

    public MarketEnv(PricingGroup pricingGroup, DataMarkerType type, int dayAdvance) {
        this.timeStamp = new Date();
        this.marketEnvId= new MarketEnvId(pricingGroup.getName());
        this.asOf = Date.from(LocalDate.now().plusDays(dayAdvance).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pricingGroup = pricingGroup;
        this.type = type;
    }
    public MarketEnv(PricingGroup pricingGroup, DataMarkerType type) {
        this(pricingGroup, type, 0);
    }

    public MarketEnvId getId() { return this.marketEnvId; }

    public Date getAsOf() {
        return asOf;
    }

    public PricingGroup getPricingGroup() {
        return pricingGroup;
    }

    public DataMarkerType getType() {
        return type;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public boolean equal(MarketEnv marketEnv) {
        return this.marketEnvId.getId().compareTo(marketEnv.getId().getId()) == 0;
    }
}
