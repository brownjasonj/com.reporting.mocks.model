package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

/*
    Delta (Δ) represents the rate of change between the option's price
    and a $1 change in the underlying asset's price. In other words, the
    price sensitivity of the option is relative to the underlying asset.
    Delta of a call option has a range between zero and one, while the delta
    of a put option has a range between zero and negative one. For example,
    assume an investor is long a call option with a delta of 0.50. Therefore,
    if the underlying stock increases by $1, the option's price would
    theoretically increase by 50 cents.
 */
public class Delta extends Risk {
    private Underlying underlying;
    protected Double value;

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
