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

    def "should throw exception when removing more stock than available"() {
        given: "a product with limited stock"
        inventoryService.addStock("Product A", 5)

        when: "attempting to remove more stock then available"
        inventoryService.removeStock("Product A", 10)

        then: "an IllegalState is thrown with correct message"
        def exception = thrown(IllegalStateException)
        exception.message == "Insufficient stock"

    }

    def "should thrown exception when removing zero or negative stock"(){
        when: "zero or negative quantity is removed"
        inventoryService.removeStock("Product A", quantity)

        then: "an illegalArgumentExc is thrown"
        def exception = thrown(IllegalArgumentException)
        exception.message == "Quantity must be greater than zero"

        where:
        quantity << [0,-5]
    }

    def "should return zero stock for nonexist product"(){
        expect: "getStock should return 0 for a product not in inventory"
        inventoryService.getStock() == 0
    }

}