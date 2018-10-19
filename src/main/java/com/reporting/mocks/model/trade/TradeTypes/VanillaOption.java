package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class VanillaOption extends Trade {
    private final String underlying2 = "underlying2";
    private final String expiryDate = "expiryDate";
    private final String strike = "strike";

    public VanillaOption() {
        super();
    }

    protected VanillaOption(String book,
                            Tcn tcn,
                            Double quantity,
                            Underlying underlying1,
                            Underlying underlying2,
                            Date expiryDate,
                            Double strike) {
        super(TradeKind.Any, TradeType.VanillaOption, tcn, book, quantity, underlying1);
        this.assignAttribute(this.underlying2, underlying2);
        this.assignAttribute(this.expiryDate, expiryDate);
        this.assignAttribute(this.strike, strike);
    }

    public VanillaOption(
            String book,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Date expiryDate,
            Double strike) {
        this(book, new Tcn(), quantity, underlying1, underlying2, expiryDate, strike);
    }

    public VanillaOption(VanillaOption vanillaOption) {
        this(vanillaOption.getBook(),
                vanillaOption.getUnderlying1Amount(),
                vanillaOption.getUnderlying1(),
                vanillaOption.getUnderlying2(),
                vanillaOption.getExpiryDate(),
                vanillaOption.getStrike());
    }


    @Override
    public VanillaOption createNewVersion() {
        return new VanillaOption(this.getBook(),
                this.getTcn().createNewVersion(),
                this.getUnderlying1Amount(),
                this.getUnderlying1(),
                this.getUnderlying2(),
                this.getExpiryDate(),
                this.getStrike());

    }

    public Underlying getUnderlying2() {
        return (Underlying)this.retreiveAttribute(this.underlying2);
    }

    public Date getExpiryDate() {
        return (Date)this.retreiveAttribute(this.expiryDate);
    }

    public Double getStrike() {
        return (Double)this.retreiveAttribute(this.strike);
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.getStrike() * -1;
    }

    @Override
    public boolean hasExpired(Date asOf) {
        Date expiryDate = this.getExpiryDate();
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
