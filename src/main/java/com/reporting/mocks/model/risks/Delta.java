package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Delta extends Risk {
    private Underlying underlying;
    private Double value;

    public Delta() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.DELTA;
    }

    public Delta(Delta r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public Delta(MarketEnvId marketEnvId, String bookName, Tcn tcn, Underlying underlying, Double value) {
        super(RiskKind.SINGLE, RiskType.DELTA, marketEnvId, bookName, tcn);
        this.underlying = underlying;
        this.value = value;
    }

    public Underlying getUnderlying() {
        return underlying;
    }

    public Double getValue() {
        return value;
    }
}
