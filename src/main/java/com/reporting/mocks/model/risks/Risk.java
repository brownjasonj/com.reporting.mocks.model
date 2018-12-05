package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.CalculationContextId;
import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;

import java.util.HashMap;
import java.util.Map;

public class Risk {
    protected MarketEnvId marketEnvId;
    protected String bookName;
    protected Tcn tcn;
    protected RiskType riskType;
    protected RiskKind riskKind;

    // protected Map<String, Object> kvp;  // set of key-value pairs representing the risk

    public Risk() {

    }

    protected Risk(Risk r) {
        this.riskKind = r.riskKind;
        this.riskType = r.riskType;
//        this.kvp = new HashMap<>();
        this.marketEnvId = r.marketEnvId;
        this.bookName = r.bookName;
        this.tcn = r.tcn;
//        this.kvp = r.kvp;
    }

    public Risk(RiskKind riskKind, RiskType riskType, MarketEnvId marketEnvId, String bookName, Tcn tcn) {
        this.riskKind = riskKind;
        this.riskType = riskType;
//        this.kvp = new HashMap<>();
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

//    public Map<String, Object> getKvp() {
//        return kvp;
//    }

    public MarketEnvId getMarketEnvId() { return this.marketEnvId; }
}
