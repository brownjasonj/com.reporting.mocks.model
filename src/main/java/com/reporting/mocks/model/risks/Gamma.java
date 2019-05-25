package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Gamma extends Risk {
    private Underlying underlying;
    protected Double value;

    public Gamma() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.GAMMA;
    }

    public Gamma(Gamma r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public Gamma(MarketEnvId marketEnvId,
              String bookName,
              Tcn tcn,
              Underlying underlying,
              Double value) {
        super(RiskKind.SINGLE, RiskType.GAMMA, marketEnvId, bookName, tcn);
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
