package se331.lab.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organizer {
    Integer id;
    String name;
    String address;
}
