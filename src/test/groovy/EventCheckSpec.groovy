import spock.lang.Specification


class EventCheckSpec extends Specification {

    private EmailSender emailSender = Mock(EmailSender.class)
    private InvoiceStorage invoiceStorage = Stub(InvoiceStorage.class)
    private EventRecorder eventRecorder = Mock(EventRecorder.class)

    private LateInvoiceNotifier lateInvoiceNotifier = new LateInvoiceNotifier(emailSender,invoiceStorage)

    private Customer sampleCustomer = new Customer(firstName: "Tomek", lastName: "Kowalski")

    def "email about late invoice should contain customer data"(){
        given: "a customer with a late invoice"
        invoiceStorage.hasOutstandingInvoice(sampleCustomer) >> true

        when: "we check if an email should be sent"
        lateInvoiceNotifier.notifyIfLate(sampleCustomer)

        then: "the customer is indeed emailed"
        1 * emailSender.sendEmail(sampleCustomer)

        and: "the event is recorded with the respective details"
        1 * eventRecorder.recordEvent({
            event ->
                event.getTimestamp() != null &&
                        event.getType() == Event.Type.REMINDER_SENT &&
                        event.getCustomerName() == "Tomek Kowalski"
        })
    }


}