package project.demo2.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

@Service
public class EventInfoService {
    private final EventInfoRepository eiRepository;
    @Autowired
    public EventInfoService(EventInfoRepository eiRepository) {
        this.eiRepository = eiRepository;
    }
    public List<EventInfo> getEventInfo(){
        return eiRepository.findAll();
    }
    public List<EventInfo> getEventInfoByCategory(int category){
        return eiRepository.findEventInfoByCategory(category);
    }

    public List<EventInfo> getEventInfoByType(int type){
        return eiRepository.findEventInfoByType(type);
    }
    public void addNewEvent(EventInfo ei, Long userID){
        Optional<EventInfo> eio = eiRepository.findEventInfoById(ei.getId());
        if(eio.isPresent()){
            throw new IllegalStateException("Event existed");
        }
        ei.setHostId(userID);
        eiRepository.save(ei);
    }

    public void deleteEvent(Long id, Long HostID){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id == HostID) eiRepository.deleteById(id);
        else throw new IllegalStateException("Not allowed to modify the event");
    }

    public void updateEventName(Long id, Long HostID, String name){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setName(name);
        eiRepository.save(ei.get(0));
    }

    public void updateEventLocation(Long id, Long HostID, String loc){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setLocation(loc);
        eiRepository.save(ei.get(0));
    }

    public void updateEventType(Long id, Long HostID, int type){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setType(type);
        eiRepository.save(ei.get(0));
    }

    public void updateEventDate(Long id, Long HostID, LocalDate date){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setDate(date);
        eiRepository.save(ei.get(0));
    }

    public void updateEventTime(Long id, Long HostID, LocalTime time){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setTime(time);
        eiRepository.save(ei.get(0));
    }

    public void updateEventCap(Long id, Long HostID, int cap){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        List<EventInfo> ei = eiRepository.getEventInfoById(id);
        Long host_id = ei.get(0).getHostID();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get(0).setCapacity(cap);
        eiRepository.save(ei.get(0));
    }
}

