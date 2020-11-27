package com.reporting.mocks.model.risks;

public enum RiskType {
    PV("PV"),
    THETA("Theta"),
    RHO("Rho"),
    DELTA("Delta"),
    GAMMA("Gamma"),
    VEGA("Vega"),
    SEGA("Sega"),
    REGA("Rega"),
    IRDELTA("IRDelta"),
    IRVEGA("IRVega");

    protected String name;

    RiskType(String name) {
        this.name = name;
    }
}
