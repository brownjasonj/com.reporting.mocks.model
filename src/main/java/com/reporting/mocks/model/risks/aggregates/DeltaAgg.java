package com.reporting.mocks.model.risks.aggregates;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.risks.RiskType;
import com.reporting.mocks.model.underlying.Underlying;

@Deprecated
public class DeltaAgg extends RiskAggregate {
    private Underlying underlying;
    private Double value;
    
    public DeltaAgg() {
        super();
        this.riskType = RiskType.DELTA;
    }

    public DeltaAgg(MarketEnvId marketEnvId,
                 RiskRunId riskRunId,
                 String bookName,
                 Underlying currency,
                 Double value) {
        super(marketEnvId, riskRunId, bookName, RiskType.DELTA);
        this.underlying = currency;
        this.value = value;
    }

    public void addValue(Double valueToAdd) {
        this.value += valueToAdd;
    }

    public void subtractValue(Double valueToSubtract) {
        this.value -= valueToSubtract;
    }

    public Underlying getUnderlying() {
        return underlying;
    }

    public void setUnderlying(Underlying underlying) {
        this.underlying = underlying;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}