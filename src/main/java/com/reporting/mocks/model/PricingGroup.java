package com.reporting.mocks.model;

import java.util.ArrayList;
import java.util.List;

public class PricingGroup {
    protected String name;
    protected List<String> tradingBooks;

    protected PricingGroup() {}

    public PricingGroup(String name, List<String> tradingBooks) {
        this.name = name;
        this.tradingBooks = new ArrayList<>(tradingBooks);
    }

    public String getName() {
        return name;
    }

    public List<String> getTradingBooks() {
        return tradingBooks;
    }
}
