package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Random;

public class Pv extends Risk {
    private final String nameValue = "value";
    private final String nameUnderlying = "underlying";

    public Pv() {
        super();
        this.riskType = RiskType.PV;
    }


    public Pv(CalculationContextId calculationId,
              MarketEnvId marketEnvId,
              TradePopulationId tradePopulationId,
              RiskRunId riskRunId,
              String bookName,
              Tcn tcn,
              Underlying currency,
              Double value) {
        super(calculationId, marketEnvId, tradePopulationId, riskRunId, bookName, tcn);
        this.riskType = RiskType.PV;
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
