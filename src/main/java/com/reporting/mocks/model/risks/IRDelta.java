package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class IRDelta extends Risk {
    private Underlying underlying;
    protected Double value;

    public IRDelta() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.IRDELTA;
    }

    public IRDelta(IRDelta r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public IRDelta(MarketEnvId marketEnvId, String bookName, Tcn tcn, Underlying underlying, Double value) {
        super(RiskKind.SINGLE, RiskType.IRDELTA, marketEnvId, bookName, tcn);
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
