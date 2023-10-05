package org.orgless.universityeventmanagement.Service;

import org.orgless.universityeventmanagement.entity.Event;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    String addEvent(Event event);

    String updateEventById(Event event);

    String deleteEventById(int id);

    List<Event> getEventsByDate(LocalDate date);
}
