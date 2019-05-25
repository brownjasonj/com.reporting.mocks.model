package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Pv extends Risk {
    private Underlying underlying;
    protected Double value;

    public Pv() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.PV;
    }


    public Pv(MarketEnvId marketEnvId,
              String bookName,
              Tcn tcn,
              Underlying currency,
              Double value) {
        super(RiskKind.SINGLE, RiskType.PV, marketEnvId, bookName, tcn);
        this.underlying = currency;
        this.value = value;
    }

    public Pv(Pv r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public Underlying getUnderlying() {
        return underlying;
    }

    public Double getValue() {
        return value;
    }
}
