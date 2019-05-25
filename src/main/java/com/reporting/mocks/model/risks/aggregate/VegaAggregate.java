package com.reporting.mocks.model.risks.aggregate;

import com.reporting.mocks.model.risks.RiskKind;
import com.reporting.mocks.model.risks.Vega;
import com.reporting.mocks.model.underlying.Underlying;

public class VegaAggregate extends RiskAggregate {
    private Underlying underlying;
    
    public VegaAggregate() {
        super();
    }

    public VegaAggregate(Vega vega) {
        super(vega);
        this.underlying = vega.getUnderlying();
    }

    public void add(Vega vega) throws RiskAggregationException {
        super.add(vega);
    }

    public void subtract(Vega vega) throws RiskAggregationException {
        super.subtract(vega);
    }
}