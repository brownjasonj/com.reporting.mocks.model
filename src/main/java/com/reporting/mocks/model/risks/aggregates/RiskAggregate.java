package com.reporting.mocks.model.risks.aggregates;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.risks.RiskKind;
import com.reporting.mocks.model.risks.RiskType;

public class RiskAggregate {
    protected MarketEnvId marketEnvId;
    protected RiskRunId riskRunId;
    protected String bookName;
    protected RiskType riskType;
    protected RiskKind riskKind;

    public RiskAggregate() {}

    public RiskAggregate(MarketEnvId marketEnvId, RiskRunId riskRunId, String bookName, RiskType riskType) {
        this.marketEnvId = marketEnvId;
        this.riskRunId = riskRunId;
        this.bookName = bookName;
        this.riskType = riskType;
        this.riskKind = RiskKind.AGGREGATE;
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

    public void setMarketEnvId(MarketEnvId marketEnvId) {
        this.marketEnvId = marketEnvId;
    }

    public void setRiskRunId(RiskRunId riskRunId) {
        this.riskRunId = riskRunId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    public void setRiskKind(RiskKind riskKind) {
        this.riskKind = riskKind;
    }
}
