package com.reporting.mocks.model.id;

import java.util.UUID;

public class MarketEnvId extends Id {
    private String pricingGroupName;

    public MarketEnvId() {
        super();
    }

    public MarketEnvId(String pricingGroupName, UUID id) {
        super("/calculationcontext/market/" + pricingGroupName, id);
        this.pricingGroupName = pricingGroupName;
    }
    public MarketEnvId(String pricingGroupName) {
        this(pricingGroupName, null);
    }
    
    public String getPricingGroupName() {
        return this.pricingGroupName;
    }
}
