package project.demo2.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "Category/{EventInfoCategory}")
    public List<EventInfo> getEventInfoByCategory(@PathVariable("EventInfoCategory") int category){
        return es.getEventInfoByCategory(category);
    }
    @GetMapping(path = "{EventInfoType}")
    public List<EventInfo> getEventInfoByType(@PathVariable("EventInfoType")int type){
        return es.getEventInfoByType(type);
    }



    @PostMapping
    public Boolean addNewEvent(@RequestBody  EventInfo ei, long userID){
        es.addNewEvent(ei, userID);
        return true;
    }

    @DeleteMapping(path = "{EventInfoId}")
    public void deleteEvent(@PathVariable("EventInfoId") Long id){
        es.deleteEvent(id);
    }

}
