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

}