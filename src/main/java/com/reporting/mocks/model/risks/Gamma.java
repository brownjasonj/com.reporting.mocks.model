package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

/*
    Gamma (Γ) represents the rate of change between an option's delta
    and the underlying asset's price. This is called second-order
    (second-derivative) price sensitivity. Gamma indicates the amount
    the delta would change given a $1 move in the underlying security.
    For example, assume an investor is long one call option on hypothetical
    stock XYZ. The call option has a delta of 0.50 and a gamma of 0.10. Therefore,
    if stock XYZ increases or decreases by $1, the call option's delta would
    increase or decrease by 0.10.
 */
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
