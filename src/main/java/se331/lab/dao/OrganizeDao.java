package se331.lab.dao;

import se331.lab.entity.Organizer;

import java.util.List;

public interface OrganizeDao {
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(int id);
}
