package com.reporting.mocks.model.risks.aggregate;

import com.reporting.mocks.model.risks.Pv;
import com.reporting.mocks.model.underlying.Underlying;

public class PvAggregate extends RiskAggregate {
    private Underlying underlying;
    private Double value;
    
    public PvAggregate() {
        super();
    }

    public PvAggregate(Pv pv) {
        super(pv);
        this.underlying = pv.getUnderlying();
        this.value = pv.getValue();
    }

    public void add(Pv pv) throws RiskAggregationException {
        super.add(pv);
        this.value += pv.getValue();
    }

    public void subtract(Pv pv) throws RiskAggregationException {
        super.subtract(pv);
        this.value -= pv.getValue();
    }
}