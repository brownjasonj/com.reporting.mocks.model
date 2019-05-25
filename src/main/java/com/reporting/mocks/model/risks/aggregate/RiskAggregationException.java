package com.reporting.mocks.model.risks.aggregate;

public class RiskAggregationException extends Exception {
    private static final long serialVersionUID = 1L;

    public RiskAggregate riskAggregate;
    
    public RiskAggregationException(RiskAggregate riskAggregate) {
        this.riskAggregate = riskAggregate;
    }
}