package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Delta extends Risk {
    protected final String nameValue = "value";
    protected final String nameUnderlying = "underlying";

    public Delta() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.DELTA;
    }

    public Delta(Risk r) {
        super(r);
    }

    public Delta(MarketEnvId marketEnvId, String bookName, Tcn tcn, Underlying underlying, Double value) {
        super(RiskKind.SINGLE, RiskType.DELTA, marketEnvId, bookName, tcn);
        this.kvp.put(this.nameValue, value);
        this.kvp.put(this.nameUnderlying, underlying);
    }

    public Double getValue() {
        return (Double)this.kvp.get(this.nameValue);
    }

    public Underlying getUnderlying() {
        return (Underlying)this.kvp.get(this.nameUnderlying);
    }
}
