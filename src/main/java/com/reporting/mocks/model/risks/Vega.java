package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;
import com.reporting.mocks.model.underlying.Underlying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Vega is defined as an matrix of values each value is a time bucket by underlying, e.g.,

    +-----+----+----+----+----+----+
    +      OIS  1mth 6mth  1yr  2yr
    + EUR  0.1   0.2  0.3  0.4  0.2
    + USD  0.11  0.21 0.2  0.3  0.1
    +-----+----+----+---+----+----+
 */
public class Vega extends Risk {
    private Underlying underlying;
    protected List<String> timeBuckets;
    protected Map<String,List<Double>> timeBucketValues;

    public Vega() {
        super();
        this.riskKind = RiskKind.SINGLE;
        this.riskType = RiskType.VEGA;
        this.timeBuckets = new ArrayList<>();
        this.timeBucketValues = new HashMap<>();
    }

    public Vega(Vega r) {
        super(r);
        this.underlying = r.getUnderlying();
        this.timeBuckets = new ArrayList<>(r.getTimeBuckets());
        this.timeBucketValues = new HashMap<>(r.getTimeBucketValues());
    }

    public Vega(MarketEnvId marketEnvId,
                String bookName,
                Tcn tcn,
                List<String> bucketNames) {
        super(RiskKind.SINGLE, RiskType.VEGA, marketEnvId, bookName, tcn);
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
