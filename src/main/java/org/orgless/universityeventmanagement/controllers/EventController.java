package org.orgless.universityeventmanagement.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.orgless.universityeventmanagement.Service.EventService;
import org.orgless.universityeventmanagement.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/")
    public String addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping("/")
    public String updateEventById(@RequestBody Event event) {
        return eventService.updateEventById(event);
    }

    @DeleteMapping("/{id}")
    public String deleteEventById(@PathVariable int id) {
        return eventService.deleteEventById(id);
    }

    @GetMapping("/")
    public List<Event> getEventsByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return eventService.getEventsByDate(date);
    }
}
