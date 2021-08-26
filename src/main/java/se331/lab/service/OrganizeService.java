package se331.lab.service;

import se331.lab.entity.Organizer;

import java.util.List;

public interface OrganizeService {
     Integer getOrganizerSize();

     List<Organizer> getOrganizers(Integer perPage, Integer page);
     Organizer getOrganizer(int id);
}
