package com.reporting.mocks.model.risks.aggregate;

import com.reporting.mocks.model.risks.Delta;
import com.reporting.mocks.model.underlying.Underlying;

public class DeltaAggregate extends RiskAggregate {
    private Underlying underlying;
    private Double value;
    
    public DeltaAggregate() {
        super();
    }

    public DeltaAggregate(Delta delta) {
        super(delta);
        this.underlying = delta.getUnderlying();
        this.value = delta.getValue();
    }

    public void add(Delta delta) throws RiskAggregationException {
        super.add(delta);
        this.value += delta.getValue();
    }

    public void subtract(Delta delta) throws RiskAggregationException {
        super.subtract(delta);
        this.value -= delta.getValue();
    }
}