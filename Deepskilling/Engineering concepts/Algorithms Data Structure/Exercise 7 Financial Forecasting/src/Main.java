public class Main {
    public static void main(String[] args) {
        FinancialForecasting forecaster = new FinancialForecasting();
        
        double presentValue = 10000.0;
        double annualGrowthRate = 0.05; 
        int years = 15;

        double standardResult = forecaster.calculateFutureValue(presentValue, annualGrowthRate, years);
        System.out.printf("Standard Recursive Forecast (Year %d): $%.2f%n", years, standardResult);

        double optimizedResult = forecaster.calculateFutureValueOptimized(presentValue, annualGrowthRate, years);
        System.out.printf("Optimized Recursive Forecast (Year %d): $%.2f%n", years, optimizedResult);
    }
}