import spock.lang.Specification
import spock.lang.Unroll

class InventoryServiceSpec extends Specification {

    static final String dummyProductName = "Product A"

    @Unroll
    def "removeStock() should throw IllegalArgumentException when stock quantity is #stockQuantity and removing #removingQuantity"() {
        given: "An inventory with initial stock"
        def stock = getStock(stockQuantity)
        def inventoryService = getInventoryService(stock)

        when: "Attempting to remove an invalid quantity from stock"
        inventoryService.removeStock(dummyProductName, removingQuantity)

        then: "An IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)

        where:
        stockQuantity | removingQuantity
        0             | 0
        0             | -1
        1             | 0
        1             | -1
    }

    private Map<String, Integer> getStock(Integer quantity) {
        return [(dummyProductName): quantity] as Map
    }

    private InventoryService getInventoryService(Map<String, Integer> stock) {
        return new InventoryService(stock: stock)
    }
}
