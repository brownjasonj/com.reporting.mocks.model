package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Pv extends Risk {
    private final String nameValue = "value";
    private final String nameUnderlying = "underlying";

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
        this.kvp.put(this.nameUnderlying, currency);
        this.kvp.put(this.nameValue, value);
    }

    public Pv(Risk r) {
        super(r);
    }

    public Double getValue() {
        return (Double)this.kvp.get(this.nameValue);
    }

    public Underlying getUnderlying() {
        return (Underlying)this.kvp.get(this.nameUnderlying);
    }
}
