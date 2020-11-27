package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

/*
    Rho (p) represents the rate of change between an option's value and a 1% change
    in the interest rate. This measures sensitivity to the interest rate. For example,
    assume a call option has a rho of 0.05 and a price of $1.25. If interest rates rise
    by 1%, the value of the call option would increase to $1.30, all else being equal.
    The opposite is true for put options. Rho is greatest for at-the-money options with
    long times until expiration.
 */
public class Rho extends Risk {
    private Underlying underlying;
    protected Double value;

    public Rho() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.RHO;
    }

    public Rho(Rho r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public Rho(MarketEnvId marketEnvId,
                 String bookName,
                 Tcn tcn,
                 Underlying currency,
                 Double value) {
        super(RiskKind.SINGLE, RiskType.RHO, marketEnvId, bookName, tcn);
        this.underlying = currency;
        this.value = value;
    }


    public Underlying getUnderlying() {
        return underlying;
    }

    public Double getValue() {
        return value;
    }
}
