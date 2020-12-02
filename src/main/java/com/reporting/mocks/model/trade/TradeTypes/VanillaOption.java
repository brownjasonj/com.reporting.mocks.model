package com.reporting.mocks.model.trade.TradeTypes;

import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeKind;
import com.reporting.mocks.model.trade.TradeType;
import com.reporting.mocks.model.underlying.Underlying;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class VanillaOption extends Trade {
    private Underlying underlying2;
    private Instant expiryDate;
    private Double strike;

    public VanillaOption() {
        super();
    }

    protected VanillaOption(String book,
                            Tcn tcn,
                            Double quantity,
                            Underlying underlying1,
                            Underlying underlying2,
                            Instant expiryDate,
                            Double strike) {
        super(TradeKind.Any, TradeType.VanillaOption, tcn, book, quantity, underlying1);
        this.underlying2 = underlying2;
        this.expiryDate = expiryDate;
        this.strike = strike;
    }

    public VanillaOption(
            String book,
            Double quantity,
            Underlying underlying1,
            Underlying underlying2,
            Instant expiryDate,
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
        return underlying2;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public Double getStrike() {
        return strike;
    }

    public Double getUnderlying2Amount() {
        return this.getUnderlying1Amount() * this.getStrike() * -1;
    }

    @Override
    public boolean hasExpired(Instant asOf) {
        Instant expiryDate = this.getExpiryDate();
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
