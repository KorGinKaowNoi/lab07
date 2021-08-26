package se331.lab.rest;
import lombok.Data;
import lombok.Builder;
@Data
@Builder
public class Event {
    Long id;
    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    String organization;
}
