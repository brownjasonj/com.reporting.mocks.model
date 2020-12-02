package com.reporting.mocks.model;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.risks.RiskType;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    A CalculationContext represents a set of associations between a risk type and a market environment.
    The association is used to determine which market environment should be used to calculate the specific
    risk.
 */
public class CalculationContext {
    protected Instant timeStamp;
    protected PricingGroup pricingGroup;
    protected CalculationContextId calculationContextId;
    protected Map<RiskType, MarketEnvId> markets;

    public CalculationContext() {
    }

    public CalculationContext(PricingGroup pricingGroup) {
        this.timeStamp = Instant.now(Clock.system(ZoneOffset.UTC));
        this.pricingGroup = pricingGroup;
        this.calculationContextId = new CalculationContextId(pricingGroup.getName());
        this.markets = new HashMap<>();
    }

    public CalculationContext(CalculationContext calcContext) {
        this(calcContext.getPricingGroup());
        this.markets = new HashMap<>(calcContext.markets);
    }

    public void update(List<RiskType> riskTypes, MarketEnv marketEnv) {
        for(RiskType riskType : riskTypes) {
            markets.put(riskType, marketEnv.getId());
        }
    }

    public void add(RiskType riskType, MarketEnv marketEnv) {
        this.markets.put(riskType, marketEnv.getId());
    }

    public MarketEnvId get(RiskType riskType) {
        return markets.get(riskType);

    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public Map<RiskType, MarketEnvId> getMarkets() {
        return markets;
    }

    public PricingGroup getPricingGroup() {
        return this.pricingGroup;
    }

    public CalculationContextId getCalculationContextId() {
        return this.calculationContextId;
    }
}
