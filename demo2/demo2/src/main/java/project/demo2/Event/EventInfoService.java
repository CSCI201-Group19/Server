package project.demo2.Event;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo2.User.UserInfo;
import project.demo2.User.UserInfoRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;
import java.util.Optional;

@Service
public class EventInfoService {
    private final EventInfoRepository eiRepository;
    private final EventRegistrationRepository erRepository;
    private final UserInfoRepository uiRepository;

    @Autowired
    public EventInfoService(EventInfoRepository eiRepository, EventRegistrationRepository erRepository, UserInfoRepository uiRepository) {
        this.eiRepository = eiRepository;
        this.erRepository = erRepository;
        this.uiRepository = uiRepository;
    }

    public List<EventInfo> getEventInfo(){
        return eiRepository.findAll();
    }
    public Optional<EventInfo> getEventInfoById(Long event_id) { return eiRepository.findEventInfoById(event_id); }
    public List<EventInfo> getEventInfoByCategory(String category){ return eiRepository.findEventInfoByCategory(category); }

    public void addNewEvent(EventInfo ei){
        Optional<EventInfo> eio = eiRepository.findEventInfoById(ei.getId());
        if(eio.isPresent()){
            throw new IllegalStateException("Event existed");
        }
        eiRepository.save(ei);

    }
    public void deleteEvent(Long id, Long HostID){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id == HostID) {
            List<EventRegistration> ers = erRepository.findEventRegistrationByEvent(ei.get());
            erRepository.deleteAll(ers);
            eiRepository.deleteById(id);
        }

        else throw new IllegalStateException("Not allowed to modify the event");
    }

    public void registerEvent(Long id, Long userId) {
        boolean exists = eiRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Event with id " + id + " does not exist.");
        }
        exists = uiRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Optional<UserInfo> ui = uiRepository.findUserInfoById(userId);

        Optional<EventRegistration> er = erRepository.findEventRegistrationByUserAndEvent(ui.get(), ei.get());
        if (er.isPresent()) {
            throw new IllegalStateException("User with id " + userId + " is already registered the event with id " + id);
        } else {
            EventRegistration temp_er = new EventRegistration(ui.get(), ei.get());
            erRepository.save(temp_er);
        }
    }

    public void updateEventName(Long id, Long HostID, String name){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setName(name);
        eiRepository.save(ei.get());
    }

    public void updateEventLocation(Long id, Long HostID, String loc){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setLocation(loc);
        eiRepository.save(ei.get());
    }

    public void updateEventType(Long id, Long HostID, String category){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setCategory(category);
        eiRepository.save(ei.get());
    }

    public void updateEventDate(Long id, Long HostID, LocalDate date){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setDate(date);
        eiRepository.save(ei.get());
    }

    public void updateEventTime(Long id, Long HostID, LocalTime time){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setTime(time);
        eiRepository.save(ei.get());
    }

    public void updateEventCap(Long id, Long HostID, int cap){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setCapacity(cap);
        eiRepository.save(ei.get());
    }
}

