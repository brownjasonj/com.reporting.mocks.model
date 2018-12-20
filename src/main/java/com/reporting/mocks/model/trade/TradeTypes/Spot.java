package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Spot extends Trade {
    private Underlying underlying2;
    private Date settlementDate;
    private Double price;

    public Spot() {
        super();
    }

    protected Spot(
            String book,
            Tcn tcn,
            Double underlyingAmount1,
            Underlying underlying1,
            Underlying underlying2,
            Date settlementDate,
            Double price
    ){
        super(TradeKind.Any, TradeType.Spot, tcn, book, underlyingAmount1, underlying1);
        this.underlying2 = underlying2;
        this.settlementDate = settlementDate;
        this.price = price;
    }
    public Spot(String book, Double underlyingAmount1, Underlying underlying1, Underlying underlying2, Date settlementDate, Double price) {
        this(book, new Tcn(), underlyingAmount1, underlying1, underlying2, settlementDate, price);
    }

    public Spot(Spot spot) {
        this(spot.getBook(),
                spot.getUnderlying1Amount(),
                spot.getUnderlying1(),
                spot.getUnderlying2(),
                spot.getSettlementDate(),
                spot.getPrice());
    }

    @Override
    public Spot createNewVersion() {
        return new Spot(
                this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getUnderlying2(),
                this.getSettlementDate(),
                this.getPrice()
        );
    }

    public Underlying getUnderlying2() {
        return underlying2;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public Double getPrice() {
        return price;
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
