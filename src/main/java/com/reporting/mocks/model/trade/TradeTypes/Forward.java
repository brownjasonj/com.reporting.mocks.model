package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Forward extends Trade {
    protected final String underlying2 = "underlying2";
    protected final String settlementDate = "settlementDate";
    protected final String price = "price";

    public Forward() {
        super();
    }

    public Forward(
            String book,
            Tcn tcn,
            Double underlying1Amount,
            Underlying underlying1,
            Underlying underlying2,
            Date settlementDate,
            Double price) {
        super(TradeKind.Any, TradeType.Forward, tcn, book, underlying1Amount, underlying1);
        this.assignAttribute(this.underlying2, underlying2);
        this.assignAttribute(this.settlementDate, settlementDate);
        this.assignAttribute(this.price, price);
    }

    public Forward(String book,
                   Double underlying1Amount,
                   Underlying underlying1,
                   Underlying underlying2,
                   Date settlementDate,
                   Double price) {
        this(book, new Tcn(), underlying1Amount, underlying1, underlying2, settlementDate, price);
    }

    public Forward(Forward forward) {
        this(forward.getBook(),
                forward.getUnderlying1Amount(),
                forward.getUnderlying1(),
                forward.getUnderlying2(),
                forward.getSettlementDate(),
                forward.getPrice());
    }


    @Override
    public Forward createNewVersion() {
        return new Forward(this);
    }

    public Underlying getUnderlying2() {
        return (Underlying)this.retreiveAttribute(this.underlying2);
    }

    public Date getSettlementDate() {
        return (Date)this.retreiveAttribute(this.settlementDate);
    }

    public Double getPrice() {
        return (Double)this.retreiveAttribute(this.price);
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.getPrice() * -1;
    }

    @Override
    public boolean hasExpired(Date asOf) {
        Date expiryDate = this.getSettlementDate();
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
