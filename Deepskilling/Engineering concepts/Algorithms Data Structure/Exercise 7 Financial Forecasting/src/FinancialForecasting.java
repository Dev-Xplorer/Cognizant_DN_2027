import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {
    
    private Map<Integer, Double> memoizationCache;

    public FinancialForecasting() {
        this.memoizationCache = new HashMap<>();
    }

    public double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public double calculateFutureValueOptimized(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        
        if (memoizationCache.containsKey(periods)) {
            return memoizationCache.get(periods);
        }

        double previousValue = calculateFutureValueOptimized(presentValue, growthRate, periods - 1);
        double currentValue = previousValue * (1 + growthRate);
        
        memoizationCache.put(periods, currentValue);
        
        return currentValue;
    }
    
    public void clearCache() {
        memoizationCache.clear();
    }
}