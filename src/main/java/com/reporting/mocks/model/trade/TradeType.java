package com.reporting.mocks.model.trade;

public enum TradeType {
    Spot("Spot"),
    Forward("Forward"),
    Swap("Swap"),
    VanillaOption("VanillaOption"),
    BarrierOption("BarrierOption"),
    Payment("Payment"),
    Balance("Balance");

    protected String name;

    TradeType(String name) {
        this.name = name;
    }
}
