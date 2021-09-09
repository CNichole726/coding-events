package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();

//    @GetMapping
//    public void displayAllEvents(Model model){
//        HashMap<String, String> events = new HashMap<>();
//            events.put("StrangeLoop", "coding conference in September");
//            events.put("Code With Pride", "for LGBTQ+ and allies");
//            events.put("Unnamed Conference", "I don't know");
////        model.addAttribute("events", events);
////        return "events/index";
//    }

    @GetMapping
    public String displayAllEvents(Model model){
        Map<String, String> eventsMap = new HashMap<>();
        eventsMap.put("StrangeLoop", "coding conference in September");
        eventsMap.put("Code With Pride", "focused on LGBTQ+ and allies");
        eventsMap.put("Unnamed Conference", "I don't know");
        model.addAttribute("events", eventsMap);
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName){
            events.add(eventName);
            return "redirect:"; //this will redirect to the root (/events)
    }

}
