package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

public class Gamma extends Risk {
    private final String nameValue = "value";
    private final String nameUnderlying = "underlying";

    public Gamma() {
        super();
        this.riskType = RiskType.GAMMA;
    }

    public Gamma(Risk r) {
        super(r);
    }

    public Gamma(MarketEnvId marketEnvId,
              String bookName,
              Tcn tcn,
              Underlying underlying,
              Double value) {
        super(marketEnvId, bookName, tcn);
        this.riskType = RiskType.GAMMA;
        this.kvp.put(this.nameUnderlying, underlying);
        this.kvp.put(this.nameValue, value);
    }
}
