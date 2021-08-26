package se331.lab.dao;

import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OrganizeDaoImpl implements OrganizeDao{
    List<Organizer> organizerList;
    @PostConstruct
    public void init(){
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(123)
                .name("donut")
                .address("house")
                .address("222/103")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(456)
                .name("donut")
                .address("house")
                .address("222/103")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(789)
                .name("donut")
                .address("house")
                .address("222/103")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(1011)
                .name("donut")
                .address("house")
                .address("222/103")
                .build()
        );
        organizerList.add(Organizer.builder()
                .id(1213)
                .name("donut")
                .address("house")
                .address("222/103")
                .build()
        );
    }
    @Override
    public Integer getOrganizerSize() {
        return organizerList.size();
    }

    @Override
    public List<Organizer> getOrganizers(Integer page, Integer perPage) {
        perPage=perPage==null?organizerList.size():perPage;
        page=page==null?1:page;
        int firstIndex = (page-1)*perPage;
        return organizerList.subList(firstIndex,firstIndex+perPage);
    }

    @Override
    public Organizer getOrganizer(int id) {
        return organizerList.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);

    }
}
