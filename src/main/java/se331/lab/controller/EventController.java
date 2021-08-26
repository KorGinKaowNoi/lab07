package se331.lab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.lab.rest.Event;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

public class EventController {
    List<Event> eventList;

    @PostConstruct
    public void init(){
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .id(123L)
                .category("power kawaii")
                .title("CSM")
                .description("CSM is fun manga")
                .location("my house")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("animal welfare")
                .title("Cat Adoption Day")
                .description("Find your new feline friend at this event.")
                .location("Meow Town")
                .date("January 28, 2022")
                .time("12:00")
                .petAllowed(true)
                .organization("Kat Laydee")
                .build());
        eventList.add(Event.builder()
                .id(789L)
                .category("MoonRiver")
                .title("Moonbeam")
                .description("Moonriver hit 80$")
                .location("my house")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(1001L)
                .category("animal welfare")
                .title("Dog Adoption Day")
                .description("Find your new canine friend at this event.")
                .location("Woof Town")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(456L)
                .category("MoonRiver")
                .title("Moonbeam")
                .description("Moonriver hit 80$")
                .location("my house")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(1002L)
                .category("MoonRiver")
                .title("Moonbeam")
                .description("Moonriver hit 80$")
                .location("my house")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(1003L)
                .category("sustainability")
                .title("Highway Cleanu")
                .description("Help pick up trash along the highway.")
                .location("Highway 50")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
        eventList.add(Event.builder()
                .id(1004L)
                .category("food")
                .title("Community Gardening")
                .description("Join us as we tend to the community edible plants.")
                .location("Flora City")
                .date("august 26 2021")
                .time("10.00 pm")
                .petAllowed(true)
                .organization("donut")
                .build());
    }

    @GetMapping("events")
    public ResponseEntity<?> getEventList(){
        return ResponseEntity.ok(eventList);
    }
}
