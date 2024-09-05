public class StockService {
    private final StockProvider stockProvider;

    public StockService(StockProvider stockProvider) {
        this.stockProvider = stockProvider;
    }

    public int getStockLevel(String product) {
        return stockProvider.getStock(product);
    }
}
