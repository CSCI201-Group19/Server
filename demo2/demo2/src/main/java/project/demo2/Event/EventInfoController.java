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

    //TODO: Update GetMapping in correspondence to EventInfoService.java
    @GetMapping(path = "Category/{EventInfoCategory}")
    public List<EventInfo> getEventInfoByCategory(@PathVariable("EventInfoCategory") String category){
        return es.getEventInfoByCategory(category);
    }
//    @GetMapping(path = "{EventInfoType}")
//    public List<EventInfo> getEventInfoByType(@PathVariable("EventInfoType")int type){
//        return es.getEventInfoByType(type);
//    }


    @GetMapping(path = "register/{event}/{user}")
    public boolean registerEvent(@PathVariable("event") Long id, @PathVariable("user") Long userID){
        boolean res = true;
        try {
            es.registerEvent(id, userID);
        } catch (IllegalStateException e){
            res = false;
        } finally{
            return res;
        }
    }

    @PostMapping
    public Boolean addNewEvent(@RequestBody  EventInfo ei, long hostID){
        es.addNewEvent(ei, hostID);
        return true;
    }

    
    @DeleteMapping(path = "{EventInfoId}/{HostID}")
    public void deleteEvent(@PathVariable("EventInfoId") Long id,@PathVariable("HostID") Long hostId){
        es.deleteEvent(id,hostId);
    }

}
