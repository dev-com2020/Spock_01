import java.util.ArrayList;
import java.util.List;

public class EventRecorder {

    private final List<Event> events = new ArrayList<>();

    // Metoda do dodawania zdarzeń
    public void recordEvent(Event event) {
        events.add(event);
    }

    // Pobieranie wszystkich nagranych zdarzeń
    public List<Event> getEvents() {
        return new ArrayList<>(events);
    }

    // Pobieranie zdarzeń według typu
    public List<Event> getEventsByType(Event.Type type) {
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getType() == type) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
}
