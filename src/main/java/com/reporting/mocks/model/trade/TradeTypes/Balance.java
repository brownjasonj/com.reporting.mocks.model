package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Balance extends Trade {
    protected final String settlementDate = "settlementDate";

    public Balance() {
        super();
    }

    protected Balance(
            String book,
            Tcn tcn,
            Double underlyingAmount1,
            Underlying underlying1,
            Date settlementDate
    ) {
        super(TradeKind.Any, TradeType.Balance, tcn, book, underlyingAmount1, underlying1);
        this.assignAttribute(this.settlementDate, settlementDate);
    }

    public Balance(String book, Double underlyingAmount1, Underlying underlying1, Date settlementDate) {
        this(book, new Tcn(), underlyingAmount1, underlying1, settlementDate);
    }

    public Balance(Balance payment) {
        this(payment.getBook(), payment.getUnderlying1Amount(), payment.getUnderlying1(), payment.getSettlementDate());
    }

    @Override
    public Balance createNewVersion() {
        return new Balance(this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getSettlementDate());
    }

    public Date getSettlementDate() {
        return (Date)this.retreiveAttribute(this.settlementDate);
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
        return notionals;
    }

    @Override
    public boolean isModifiable() {
        return false;
    }
}
