package org.orgless.universityeventmanagement.persistence;

import org.orgless.universityeventmanagement.entity.Event;
import java.time.LocalDate;
import java.util.List;

public interface EventDAO {
    void save(Event event);

    void update(Event event);

    boolean deleteById(int id);

    List<Event> getByDate(LocalDate date);
}
