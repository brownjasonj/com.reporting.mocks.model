package com.reporting.mocks.model;

import java.util.Date;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.id.RiskRunId;
import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.risks.Risk;

public class RiskResult<R extends Risk> {
    protected Date timeStamp;
    protected MarketEnvId marketEnvId;
    protected TradePopulationId tradePopulationId;
    protected RiskRunId riskRunId;
    protected int fragmentCount;
    protected int fragmentNo;
    protected R risk;
    protected boolean isDeleteEvent;               // true if the contained results are a consequence of trades being removed

    public RiskResult() {}

    public RiskResult(RiskRunId riskRunId,
                         MarketEnvId marketEnvId,
                         TradePopulationId tradePopulationId,
                         int fragmentCount,
                         int fragmentNo,
                         R risk,
                         boolean isDeleteEvent) {
        this.timeStamp = new Date();
        this.riskRunId = riskRunId;
        this.marketEnvId = marketEnvId;
        this.tradePopulationId = tradePopulationId;
        this.fragmentCount = fragmentCount;
        this.fragmentNo = fragmentNo;
        this.risk = risk;
        this.isDeleteEvent = isDeleteEvent;
    }

    public MarketEnvId getMarketEnvId() {
        return marketEnvId;
    }

    public TradePopulationId getTradePopulationId() {
        return tradePopulationId;
    }

    public RiskRunId getRiskRunId() {
        return riskRunId;
    }

    public int getFragmentCount() {
        return fragmentCount;
    }

    public int getFragmentNo() {
        return fragmentNo;
    }

    public R getRisk() {
        return risk;
    }

    public boolean isDeleteEvent() {
        return isDeleteEvent;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }
}
