package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;

public class Risk {
    protected MarketEnvId marketEnvId;
    protected String bookName;
    protected Tcn tcn;
    protected RiskType riskType;
    protected RiskKind riskKind;

    public Risk() {
    }

    protected Risk(Risk r) {
        this.riskKind = r.riskKind;
        this.riskType = r.riskType;
        this.marketEnvId = r.marketEnvId;
        this.bookName = r.bookName;
        this.tcn = r.tcn;
    }

    public Risk(RiskKind riskKind, RiskType riskType, MarketEnvId marketEnvId, String bookName, Tcn tcn) {
        this.riskKind = riskKind;
        this.riskType = riskType;
        this.marketEnvId = marketEnvId;
        this.bookName = bookName;
        this.tcn = tcn;
    }

    public String getBookName() {
        return bookName;
    }

    public Tcn getTcn() {
        return tcn;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public RiskKind getRiskKind() {
        return riskKind;
    }

    public MarketEnvId getMarketEnvId() { return this.marketEnvId; }
}
