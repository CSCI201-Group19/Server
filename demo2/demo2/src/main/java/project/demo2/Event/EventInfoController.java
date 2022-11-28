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



    @PostMapping(path="/CreateEvent")
    //public Boolean addNewEvent(@RequestBody  EventInfo ei, Long hostID){
        //es.addNewEvent(ei, hostID);
    public Boolean addNewEvent(@RequestBody  EventInfo ei){
    es.addNewEvent(ei);
        return true;
    }

    
    @DeleteMapping(path = "{EventInfoId}/{HostID}")
    public void deleteEvent(@PathVariable("EventInfoId") Long id,@PathVariable("HostID") Long hostId){
        es.deleteEvent(id,hostId);
    }

}
