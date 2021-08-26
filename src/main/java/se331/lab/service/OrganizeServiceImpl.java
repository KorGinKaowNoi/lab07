package se331.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se331.lab.dao.EventDao;
import se331.lab.dao.OrganizeDao;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;

import java.util.List;
@Service
public class OrganizeServiceImpl implements OrganizeService {
    @Autowired
    OrganizeDao organizeDao;

    @Override
    public Integer getOrganizerSize() {
        return organizeDao.getOrganizerSize();
    }

    @Override
    public List<Organizer> getOrganizers(Integer perPage, Integer page) {
        return organizeDao.getOrganizers(perPage,page);
    }

    @Override
    public Organizer getOrganizer(int id) {
        return organizeDao.getOrganizer(id);
    }
}

