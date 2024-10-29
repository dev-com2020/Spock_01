import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRecorder {
    private final List<Event> events = new ArrayList<>();

    public void recordEvent(Event.Type type, String customerName, LocalDate timestamp){
        events.add(new Event(type,customerName,timestamp));
    }


}
