package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

/*
    Theta (Θ) represents the rate of change between the option price and time,
    or time sensitivity - sometimes known as an option's time decay. Theta
    indicates the amount an option's price would decrease as the time to expiration
    decreases, all else equal. For example, assume an investor is long an option
    with a theta of -0.50. The option's price would decrease by 50 cents every day
    that passes, all else being equal.
 */
public class Theta extends Risk {
    private Underlying underlying;
    protected Double value;

    public Theta() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.THETA;
    }

    public Theta(Theta r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.value = r.getValue();
    }

    public Theta(MarketEnvId marketEnvId,
              String bookName,
              Tcn tcn,
              Underlying currency,
              Double value) {
        super(RiskKind.SINGLE, RiskType.THETA, marketEnvId, bookName, tcn);
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
