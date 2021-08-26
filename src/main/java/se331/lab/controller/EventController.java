package se331.lab.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.Event;
import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EventController {
    List<Event> eventList;
    HttpHeaders responseHeader = new HttpHeaders();
    @PostConstruct
    public void init(){
        eventList = new ArrayList<>();
        responseHeader.set("x-total-count",String.valueOf(eventList.size()));
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
    public ResponseEntity<?> getEventList(@RequestParam(value = "_limit",required = false)
                                          Integer perPage, @RequestParam(value = "_page",required = false) Integer page){
        perPage=perPage==null?eventList.size():perPage;
        page=page==null?1:page;
        Integer firstIndex = (page-1)*perPage;
        List<Event> output = new ArrayList<>();
        try{
            for(int i=firstIndex;i<firstIndex+perPage;i++){
                output.add(eventList.get(i));
            }
            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
        }catch (IndexOutOfBoundsException ex){
            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
        }
    }


    @GetMapping("events/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id){
        Event output = null;
        for(Event e:eventList){
            if (e.getId().equals(id)){
                output = e;
                break;
            }
        }
        if (output!=null){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"the given id is not found");
        }
    }
}
