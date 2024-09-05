import spock.lang.Specification

class StockServiceSpec extends Specification{
    def "should return correct stock levels"(){
        given: "a mock stock provider"
        def stockProvider = Mock(StockProvider)
        def stockService = new StockService(stockProvider)

        when: "requesting stock levels for diffrent products"
        stockProvider.getStock("Product A") >> 10
        stockProvider.getStock("Product B") >> 5

        then: "the correct stock levels are returned"
        stockService.getStockLevel("Product A") == 10
        stockService.getStockLevel("Product B") == 5
    }
}
