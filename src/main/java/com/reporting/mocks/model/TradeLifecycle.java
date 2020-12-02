package com.reporting.mocks.model;

import com.reporting.mocks.model.trade.Trade;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

public class TradeLifecycle {
    protected Instant timeStamp;
    protected Trade tradeBeforeLifeCycle;           // trade before the lifecycle
    protected Trade tradeAfterLifeCycle;            // trade after the lifecycle
    protected TradeLifecycleType lifecycleType;

    public TradeLifecycle(TradeLifecycleType type, Trade tradeBeforeLifeCycle, Trade tradeAfterLifeCycle) {
        this.timeStamp = Instant.now(Clock.system(ZoneOffset.UTC));
        this.tradeBeforeLifeCycle = tradeBeforeLifeCycle;
        this.tradeAfterLifeCycle = tradeAfterLifeCycle;
        this.lifecycleType = type;
    }

    public Trade getTradeBeforeLifeCycle() {
        return tradeBeforeLifeCycle;
    }

    public Trade getTradeAfterLifeCycle() {
        return tradeAfterLifeCycle;
    }

    public TradeLifecycleType getLifecycleType() {
        return lifecycleType;
    }
}
