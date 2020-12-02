package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class Swap extends Trade {
    private Underlying underlying2;
    private Instant nearSettlementDate;
    private Instant farSettlementDate;
    private Double price;

    public Swap() {
        super();
    }

    protected Swap(
            String book,
            Tcn tcn,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Instant nearSettlementDate,
            Instant farSettlementDate,
            Double price) {
        super(TradeKind.Any, TradeType.Swap, tcn, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.nearSettlementDate = nearSettlementDate;
        this.farSettlementDate = farSettlementDate;
        this.price = price;
    }

    public Swap(
            String book,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Instant nearSettlementDate,
            Instant farSettlementDate,
            Double price
            ) {
        this(book, new Tcn(), quantity, underlying1, underlying2, nearSettlementDate, farSettlementDate, price);
    }

    public Swap(Swap swap) {
        this(swap.getBook(),
                swap.getUnderlying1Amount(),
                swap.getUnderlying1(),
                swap.getUnderlying2(),
                swap.getNearSettlementDate(),
                swap.getFarSettlementDate(),
                swap.getPrice());
    }

    @Override
    public Swap createNewVersion() {
        return new Swap(this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getUnderlying2(),
                this.getNearSettlementDate(),
                this.getFarSettlementDate(),
                this.getPrice());
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Instant getNearSettlementDate() {
        return nearSettlementDate;
    }

    public Instant getFarSettlementDate() {
        return farSettlementDate;
    }

    public Double getPrice() {
        return price;
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.getPrice() * -1;
    }

    @Override
    public boolean hasExpired(Instant asOf) {
        Instant expiryDate = this.getFarSettlementDate();
        return expiryDate.compareTo(asOf) <= 0;
    }

    @Override
    public Map<String, Double> getNotionals() {
        Map<String, Double> notionals = new HashMap<>();
        notionals.put(this.getUnderlying1().getName(), this.getUnderlying1Amount());
        notionals.put(this.getUnderlying2().getName(), this.getUnderlying2Amount());
        return notionals;
    }
}
