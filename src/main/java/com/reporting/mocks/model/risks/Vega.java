package com.reporting.mocks.model.risks;

import com.reporting.mocks.model.id.MarketEnvId;
import com.reporting.mocks.model.trade.Tcn;

import java.util.List;

/*
    Vega is defined as an matrix of values each value is a time bucket by underlying, e.g.,

    +-----+----+----+----+----+----+
    +      OIS  1mth 6mth  1yr  2yr
    + EUR  0.1   0.2  0.3  0.4  0.2
    + USD  0.11  0.21 0.2  0.3  0.1
    +-----+----+----+---+----+----+
 */
public class Vega extends Risk {
    private final String nameTimeBuckets = "timeBuckets";
    private final String nameTimeBucketValues = "timeBucketValues";
    private final String nameCurrency = "underlying";


    public Vega() {
        super();
        this.riskType = RiskType.VEGA;
    }

    public Vega(Risk r) {
        super(r);
    }

    public Vega(MarketEnvId marketEnvId,
                String bookName,
                Tcn tcn,
                List<String> bucketNames) {
        super(marketEnvId, bookName, tcn);
        this.riskType = RiskType.VEGA;
        this.kvp.put(this.nameTimeBuckets, bucketNames);    }

    public void addTimeBuckValues(String underlying, List<Double> bucketValues) {
        this.kvp.put(underlying, bucketValues);
    }
}
