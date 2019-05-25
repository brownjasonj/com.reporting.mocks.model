package com.reporting.mocks.model.risks.aggregate;

import com.reporting.mocks.model.risks.Gamma;
import com.reporting.mocks.model.underlying.Underlying;

public class GammaAggregate extends RiskAggregate {
    private Underlying underlying;
    private Double value;
    
    public GammaAggregate() {
        super();
    }

    public GammaAggregate(Gamma gamma) {
        super(gamma);
        this.underlying = gamma.getUnderlying();
        this.value = gamma.getValue();
    }

    public void add(Gamma gamma) throws RiskAggregationException {
        super.add(gamma);
        this.value += gamma.getValue();
    }

    public void subtract(Gamma gamma) throws RiskAggregationException {
        super.subtract(gamma);
        this.value -= gamma.getValue();
    }
}