package com.reporting.mocks.model.risks.aggregate;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.risks.Risk;
import com.reporting.mocks.model.risks.RiskKind;
import com.reporting.mocks.model.risks.RiskType;
import com.reporting.mocks.model.trade.Tcn;

public class RiskAggregate {
    protected Date created;
    protected Date lastUpdate;
    protected MarketEnvId marketEnvId;
    protected RiskRunId riskRunId;
    protected String bookName;
    protected RiskType riskType;
    protected RiskKind riskKind;
    protected List<Tcn> tcns;

    public RiskAggregate() {
        this.riskKind = RiskKind.AGGREGATE;
        this.tcns = new LinkedList<>();
        this.created = new Date();
        this.lastUpdate = new Date();
    }

    public RiskAggregate(Risk risk) {
        this();
        this.marketEnvId = risk.getMarketEnvId();
        this.bookName = risk.getBookName();
        this.riskType = risk.getRiskType();
        this.tcns.add(risk.getTcn());
    }

    public void updateTime() {
        this.lastUpdate = new Date();
    }

    public void add(Risk r) {
        this.tcns.add(r.getTcn());
        this.updateTime();
    }

    public void subtract(Risk r) {
        this.tcns.add(r.getTcn());
        this.updateTime();
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
