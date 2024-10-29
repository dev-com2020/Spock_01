import spock.lang.Specification
import spock.lang.Unroll


class InventoryServiceTest extends Specification {

    def inventoryService = new InventoryService()

    @Unroll
    def "should add stock correctly for #product"() {
        given: "a product and initial quantity"
        inventoryService.addStock(product, initialQuantity)

        when: "additional quantity is added"
        inventoryService.addStock(product, additionalQuantity)

        then: "total quantity should be correct"
        inventoryService.getStock(product) == expectedTotalQuantity

        where:
        product     |   initialQuantity |   additionalQuantity  ||   expectedTotalQuantity
        "Product A" |   10              |   5                   ||  15
        "Product B" |   0               |   20                  ||  20
        "Product C" |   5               |   10                  ||  15
    }

}