import spock.lang.Specification


class LateInvoiceNotifierSpec extends Specification {
    private LateInvoiceNotifier lateInvoiceNotifier

    private EmailSender emailSender
    private InvoiceStorage invoiceStorage

    private Customer sampleCustomer

    void setup(){
        invoiceStorage = Stub(InvoiceStorage.class)
        emailSender = Mock(EmailSender.class)
        lateInvoiceNotifier = new LateInvoiceNotifier(emailSender,invoiceStorage)
        sampleCustomer = new Customer()
        sampleCustomer.setFirstName("Tomek")
        sampleCustomer.setLastName("Kowalski")
    }

    def "a late invoice should trigger an email"() {
        given: "a customer with a late invoice"
        invoiceStorage.hasOutstandingInvoice(sampleCustomer) >> true

        when: "we check if an emial should be sent"
        lateInvoiceNotifier.notifyIfLate(sampleCustomer)

        then: "the customer is indeed emailed"
        1 * emailSender.sendEmail(sampleCustomer)
//        verify(emailSender, times(1).sendEmail(sampleCustomer);
    }

    def "no late invoices"() {
        given: "a customer with a good invoice"
        invoiceStorage.hasOutstandingInvoice(sampleCustomer) >> false

        when: "we check if an emial should be sent"
        lateInvoiceNotifier.notifyIfLate(sampleCustomer)

        then: "the customer is indeed emailed"
        0 * emailSender.sendEmail(sampleCustomer)
    }

}