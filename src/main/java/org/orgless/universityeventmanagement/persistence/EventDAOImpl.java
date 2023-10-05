package org.orgless.universityeventmanagement.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.orgless.universityeventmanagement.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import utils.EventNotFoundException;

import java.time.LocalDate;
import java.util.List;


@Repository
public class EventDAOImpl implements EventDAO {
    private final EntityManager entityManager;

    @Autowired
    public EventDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Event event) {
        entityManager.persist(event);
    }

    @Override
    public void update(Event event) {
        if(entityManager.find(Event.class, event.getEventId()) == null)
            throw new EventNotFoundException(event.getEventId());

        entityManager.merge(event);
    }

    @Override
    public boolean deleteById(int id) {
        var query = entityManager.createQuery("delete from Event where eventId = :id");
        query.setParameter("id", id);

        return query.executeUpdate() > 0;
    }

    @Override
    public List<Event> getByDate(LocalDate date) {
        TypedQuery<Event> query = entityManager.createQuery("from Event where eventDate = :date", Event.class);
        query.setParameter("date", date);

        return query.getResultList();
    }
}
