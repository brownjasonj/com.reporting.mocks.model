package com.reporting.mocks.model.risks.aggregates;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.risks.RiskKind;
import com.reporting.mocks.model.risks.RiskType;
import com.reporting.mocks.model.underlying.Underlying;

public class PvAgg extends RiskAggregate {
    private final String nameValue = "value";
    private final String nameUnderlying = "underlying";

    public PvAgg() {
        super();
        this.riskType = RiskType.PV;
    }

    public PvAgg(MarketEnvId marketEnvId,
                 RiskRunId riskRunId,
                 String bookName,
                 Underlying currency,
                 Double value) {
        super(marketEnvId, riskRunId, bookName, RiskType.PV);
        this.kvp.put(this.nameUnderlying, currency);
        this.kvp.put(this.nameValue, value);
    }

    public void addValue(Double valueToAdd) { this.kvp.put(this.nameValue, (Double)this.kvp.get(this.nameValue) + valueToAdd);}
    public Double getValue() {
        return (Double)this.kvp.get(this.nameValue);
    }

    public Underlying getUnderlying() {
        return (Underlying)this.kvp.get(this.nameUnderlying);
    }

}
