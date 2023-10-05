package org.orgless.universityeventmanagement.Service;

import jakarta.transaction.Transactional;
import org.orgless.universityeventmanagement.entity.Event;
import org.orgless.universityeventmanagement.persistence.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.EventNotFoundException;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private EventDAO eventDAO;

    @Autowired
    public EventServiceImpl(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    @Transactional
    public String addEvent(Event event) {
        event.setEventId(0);
        eventDAO.save(event);
        return "EVENT WAS ADDED \n" + event;
    }

    @Override
    @Transactional
    public String updateEventById(Event event) {
        eventDAO.update(event);
        return "EVENT UPDATED \n" + event;
    }

    @Override
    @Transactional
    public String deleteEventById(int id) {
        if(eventDAO.deleteById(id))
            return "EVENT DELETED ID=(" + id + ")";

        throw new EventNotFoundException(id);
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return eventDAO.getByDate(date);
    }


}
