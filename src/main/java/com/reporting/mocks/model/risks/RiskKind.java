package com.reporting.mocks.model.risks;

public enum RiskKind {
    SINGLE("SINGLE"),
    AGGREGATE("AGGREGATE");

    protected String name;

    private RiskKind(String name) {
        this.name = name;
    }
}
