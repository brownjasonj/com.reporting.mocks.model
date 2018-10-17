package com.reporting.mocks.model.risks;

public class IntradayRiskType {
    protected RiskType riskType;
    protected int periodicity;

    protected IntradayRiskType() {}

    public IntradayRiskType(RiskType riskType, int periodicity) {
        this.riskType = riskType;
        this.periodicity = periodicity;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public int getPeriodicity() {
        return periodicity;
    }
}
