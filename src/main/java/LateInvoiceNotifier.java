import java.time.LocalDate;

public class LateInvoiceNotifier {

    private final EmailSender emailSender;
    private final InvoiceStorage invoiceStorage;
    private final EventRecorder eventRecorder;

    public LateInvoiceNotifier(final EmailSender emailSender, final InvoiceStorage invoiceStorage, EventRecorder eventRecorder){
        this.emailSender = emailSender;
        this.invoiceStorage = invoiceStorage;
        this.eventRecorder = eventRecorder;
    }

    public void notifyIfLate(Customer customer)
    {
        if(invoiceStorage.hasOutstandingInvoice(customer)){
            emailSender.sendEmail(customer);
            Event event = new Event(Event.Type.REMINDER_SENT, customer.getFullName(), LocalDate.now());
            eventRecorder.recordEvent(event);
        }
    }
}