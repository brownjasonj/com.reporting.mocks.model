package com.reporting.mocks.model.risks.aggregates;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.risks.RiskKind;
import com.reporting.mocks.model.risks.RiskType;

import java.util.HashMap;
import java.util.Map;

public class RiskAggregate {
    protected MarketEnvId marketEnvId;
    protected RiskRunId riskRunId;
    protected String bookName;
    protected RiskType riskType;
    protected RiskKind riskKind;

    protected Map<String, Object> kvp;  // set of key-value pairs representing the risk

    public RiskAggregate() { kvp = new HashMap<>(); }

    public RiskAggregate(MarketEnvId marketEnvId, RiskRunId riskRunId, String bookName, RiskType riskType) {
        this.marketEnvId = marketEnvId;
        this.riskRunId = riskRunId;
        this.bookName = bookName;
        this.riskType = riskType;
        this.riskKind = RiskKind.AGGREGATE;
        this.kvp = new HashMap<>();
    }

    public MarketEnvId getMarketEnvId() {
        return marketEnvId;
    }

    public RiskRunId getRiskRunId() {
        return riskRunId;
    }

    public String getBookName() {
        return bookName;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public RiskKind getRiskKind() {
        return riskKind;
    }

    public Map<String,Object> getKvp() { return this.kvp; }

    public void setKvp(Map<String, Object> kvp) { this.kvp = kvp; }
}
