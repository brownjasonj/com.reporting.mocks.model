package com.reporting.mocks.model;

import com.reporting.mocks.model.trade.Trade;

public class TradeLifecycle {
    protected Trade tradeBeforeLifeCycle;           // trade before the lifecycle
    protected Trade tradeAfterLifeCycle;            // trade after the lifecycle
    protected TradeLifecycleType lifecycleType;

    public TradeLifecycle(TradeLifecycleType type, Trade tradeBeforeLifeCycle, Trade tradeAfterLifeCycle) {
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
