import java.util.ArrayList;
import java.util.List;

interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void update(String stockSymbol, double stockPrice);
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void setStockPrice(String stockSymbol, double stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        System.out.println("\n[MARKET UPDATE] " + stockSymbol + " is now $" + stockPrice);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("System: A new observer has registered.");
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
        System.out.println("System: An observer has deregistered.");
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }
}

class MobileApp implements Observer {
    private String username;

    public MobileApp(String username) {
        this.username = username;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Mobile Push [" + username + "]: " + stockSymbol + " price changed to $" + stockPrice);
    }
}

// 5. Concrete Observer 2
class WebApp implements Observer {
    private String browserId;

    public WebApp(String browserId) {
        this.browserId = browserId;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Web Dashboard [" + browserId + "]: Live ticker updated -> " + stockSymbol + ": $" + stockPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket nasdaq = new StockMarket();

        Observer mobileClient1 = new MobileApp("Alice");
        Observer mobileClient2 = new MobileApp("Bob");
        Observer webDashboard = new WebApp("Chrome-Session-99");

        System.out.println("--- Subscribing Clients ---");
        nasdaq.registerObserver(mobileClient1);
        nasdaq.registerObserver(mobileClient2);
        nasdaq.registerObserver(webDashboard);

        nasdaq.setStockPrice("AAPL", 150.25);
        nasdaq.setStockPrice("TSLA", 799.50);

        System.out.println("\n--- Bob unsubscribes from notifications ---");
        nasdaq.deregisterObserver(mobileClient2);

        nasdaq.setStockPrice("GOOGL", 2800.00);
    }
}