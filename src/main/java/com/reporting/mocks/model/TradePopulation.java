package com.reporting.mocks.model;

import com.reporting.mocks.model.id.TradePopulationId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.trade.Trade;
import com.reporting.mocks.model.trade.TradeType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TradePopulation {
    protected TradePopulationId tradePopulationId;
    protected String pricingGroupName;
    protected ConcurrentHashMap<UUID, Trade> tcnTrades;
    protected ConcurrentHashMap<TradeType, List<Trade>> tradeTypeTrades;
    protected Date asOf;
    protected DataMarkerType type;


    public UUID getUUID() { return this.tradePopulationId.getId();}

    public TradePopulationId getId() {
        return this.tradePopulationId;
    }

    public Collection<Trade> getAllTrades() {
        return this.tcnTrades.values();
    }

    public List<Trade> getByTradeType(TradeType tradeType) { return this.tradeTypeTrades.get(tradeType);}

    public Map<TradeType, List<Trade>> tradeTypeToTradeMapping() { return this.tradeTypeTrades; }

    public List<TradeType> getAllTradeTypes() {
        return Collections.list(tradeTypeTrades.keys());
    }

    public int getTradeCount() {
        return this.tcnTrades.size();
    }

    public DataMarkerType getType() {
        return type;
    }

    public Date getAsOf() {
        return asOf;
    }

    public Trade getTrade(Tcn tcn) {
        if (this.tcnTrades.containsKey(tcn.getId())) {
            return this.tcnTrades.get(tcn.getId());
        }
        else {
            return null;
        }
    }
}
