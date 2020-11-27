package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sega extends Risk {
    private Underlying underlying;
    protected List<String> timeBuckets;
    protected Map<String,List<Double>> timeBucketValues;

    public Sega() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.SEGA;
        this.timeBuckets = new ArrayList<>();
        this.timeBucketValues = new HashMap<>();
    }

    public Sega(Sega r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.timeBuckets = new ArrayList<>(r.getTimeBuckets());
        this.timeBucketValues = new HashMap<>(r.getTimeBucketValues());
    }

    public Sega(MarketEnvId marketEnvId,
                String bookName,
                Tcn tcn,
                List<String> bucketNames) {
        super(RiskKind.SINGLE, RiskType.SEGA, marketEnvId, bookName, tcn);
        this.timeBuckets = new ArrayList<>(bucketNames);
        this.timeBucketValues = new HashMap<>();
    }

    public void addTimeBuckValues(String underlying, List<Double> bucketValues) {
        this.timeBucketValues.put(underlying, new ArrayList<>(bucketValues));
    }

    public Underlying getUnderlying() {
        return underlying;
    }

    public List<String> getTimeBuckets() {
        return timeBuckets;
    }

    public Map<String, List<Double>> getTimeBucketValues() {
        return timeBucketValues;
    }
}
