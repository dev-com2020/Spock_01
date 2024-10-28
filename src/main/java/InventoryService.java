import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String, Integer> stock = new HashMap<>();

    public void addStock(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public void removeStock(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        int currentStock = stock.getOrDefault(product, 0);
        if (currentStock < quantity) {
            throw new IllegalStateException("Insufficient stock");
        }
        stock.put(product, currentStock - quantity);
    }

    public int getStock(String product) {
        return stock.getOrDefault(product, 0);
    }
}
