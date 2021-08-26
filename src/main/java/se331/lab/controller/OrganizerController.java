package se331.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.entity.Organizer;
import se331.lab.service.OrganizeService;

import java.util.List;

@Controller
public class OrganizerController {

    @Autowired
    OrganizeService organizeService;

    @GetMapping("organizers")
    public ResponseEntity<?> getOrganizerList(@RequestParam(value = "_limit",required = false)
                                                  Integer perPage, @RequestParam(value = "_page",required = false) Integer page){
        HttpHeaders responseHeader = new HttpHeaders();
        List<Organizer> output = null;
        int eventSize = organizeService.getOrganizerSize();
        responseHeader.set("x-total-count",String.valueOf(eventSize));
        try{
            output = organizeService.getOrganizers(perPage,page);
            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
        }catch (IndexOutOfBoundsException ex){
            return new ResponseEntity<>(output,responseHeader,HttpStatus.OK);
        }
    }


    @GetMapping("organizer/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") int id){
        Organizer output = organizeService.getOrganizer(id);
        if (output!=null){
            return ResponseEntity.ok(output);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"the given id is not found");
        }
    }
}
