package com.sheldon.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description of this file
 *
 * @author Sheldon.Wei.Xiaodong
 * @since 21/10/24 15:36
 */
@RestController
@RequestMapping("event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String action() {
        eventService.serve();
        return "event\n";
    }
}
