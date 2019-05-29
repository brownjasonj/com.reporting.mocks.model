package com.reporting.mocks.model.id;

import java.util.UUID;

public class TradePopulationId extends Id {
    private String pricingGroupName;

    public TradePopulationId() {
        super();
    }

    public TradePopulationId(String pricingGroupName, UUID id) {
        super("/tradepopulation/" + pricingGroupName, id);
        this.pricingGroupName = pricingGroupName;
    }

    public TradePopulationId(String pricingGroupName) {
        this(pricingGroupName, null);
    }
    
    public String getPricingGroupName() {
        return this.pricingGroupName;
    }
}
