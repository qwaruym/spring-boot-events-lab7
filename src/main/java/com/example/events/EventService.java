package com.example.events;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EventService {
    private final List<EventInfo> events = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<EventInfo> getAllEvents() {
        return events;
    }

    public Optional<EventInfo> getEventById(Long id) {
        return events.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    public EventInfo createEvent(EventInfo event) {
        event.setId(idGenerator.getAndIncrement());
        events.add(event);
        return event;
    }

    public Optional<EventInfo> updateEvent(Long id, EventInfo updatedEvent) {
        return getEventById(id).map(existing -> {
            existing.setTitle(updatedEvent.getTitle());
            existing.setLocation(updatedEvent.getLocation());
            return existing;
        });
    }

    public boolean deleteEvent(Long id) {
        return events.removeIf(e -> e.getId().equals(id));
    }
}