package project.demo2.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/EventInfo")
public class EventInfoController {
    private final EventInfoService es;

    @Autowired
    public EventInfoController(EventInfoService e) {
        this.es = e;
    }

    @GetMapping
    public List<EventInfo> getEventInfo(){
        return es.getEventInfo();
    }

    //TODO: Update GetMapping in correspondence to EventInfoService.java
    @GetMapping(path = "Category/{EventInfoCategory}")
    public List<EventInfo> getEventInfoByCategory(@PathVariable("EventInfoCategory") String category){
        return es.getEventInfoByCategory(category);
    }

    @GetMapping(path = "createdBy/{username}")
    public List<EventInfo> getEventInfoCreatedByUser(@PathVariable("username") String username){
        return es.getEventInfoCreatedByUser(username);
    }

    @GetMapping(path = "User/{id}")
    public List<EventInfo> getEventInfoByUser(@PathVariable("id") Long id){
        return es.getEventInfoByUser(id);
    }

    @GetMapping(path = "User/{username}/{date}")
    public List<EventInfo> getEventInfoByUserAndDate(@PathVariable("username") String username,
                                                     @PathVariable("date") String dateString){
        LocalDate date = LocalDate.parse(dateString);
        return es.getEventInfoByUserAndDate(username, date);
    }

    @GetMapping(path = "register/{eventID}/{userName}")
    public Boolean registerEvent(@PathVariable("eventID") Long id, @PathVariable("userName") String userName){
        //es.registerEvent(id, userName);
        //return true;
        return es.registerEvent(id, userName);
    }

    @PostMapping(path="/CreateEvent")
    //public Boolean addNewEvent(@RequestBody  EventInfo ei, Long hostID){
        //es.addNewEvent(ei, hostID);
    public Boolean addNewEvent(@RequestBody  EventInfo ei){
        es.addNewEvent(ei);
        return true;
    }


    
    @DeleteMapping(path = "deleteEvent/{EventInfoId}/{HostUsername}")
    public Boolean deleteEvent(@PathVariable("EventInfoId") Long id,@PathVariable("HostUsername") String username){
        return es.deleteEvent(id,username);
    }

}
