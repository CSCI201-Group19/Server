package project.demo2.Event;

import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo2.User.UserInfo;
import project.demo2.User.UserInfoRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.*;

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
    public List<EventInfo> getEventInfoByUser(Long id){
        List<EventRegistration> eventRegistrations = erRepository.findEventRegistrationByUser(uiRepository.getReferenceById(id));
        List<EventInfo> eventInfos = new ArrayList<EventInfo>();
        for (EventRegistration er: eventRegistrations){
            Optional<EventInfo> ei = eiRepository.findEventInfoById(er.getEvent().getId());
            if (ei.isPresent()){
                eventInfos.add(ei.get());
            }
        }
        return eventInfos;
    }

    public List<EventInfo> getEventInfoCreatedByUser(Long id) {
        return eiRepository.findEventInfoByHostID(id);
    }



    //public void addNewEvent(EventInfo ei, Long hostID){
    public void addNewEvent(EventInfo ei){
        Optional<EventInfo> eio = eiRepository.findEventInfoById(ei.getId());
        if(eio.isPresent()){
            throw new IllegalStateException("Event existed");
        }
        eiRepository.save(ei);
        EventRegistration er = new EventRegistration();
        er.setEvent(ei);
        er.setUser(uiRepository.getReferenceById(ei.getHostId()));
        erRepository.save(er);
    }
    public void deleteEvent(Long id, Long HostID){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id == HostID) {
            List<EventRegistration> ers = erRepository.findEventRegistrationByEvent(ei.get());
            erRepository.deleteAll(ers);
            eiRepository.deleteById(id);
        }
        else
            throw new IllegalStateException("Not allowed to modify the event");
    }

    public void registerEvent(Long id, Long userId) {
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Optional<UserInfo> ui = uiRepository.findUserInfoById(userId);
        if (!ei.isPresent())
            throw new IllegalStateException("Event with id " + id + " does not exist.");
        if (!ui.isPresent())
            throw new IllegalStateException("User with id " + userId + " does not exist.");


        Optional<EventRegistration> er = erRepository.findEventRegistrationByUserAndEvent(ui.get(), ei.get());
        List<EventRegistration> registrations = erRepository.findEventRegistrationByUser(ui.get());
        if (er.isPresent()) {
            throw new IllegalStateException("User with id " + userId + " is already registered the event with id " + id);
        }
        else if (registrations.size() >= eiRepository.getReferenceById(id).getCapacity()){
            throw new IllegalStateException("Event with id  " + id + " is already full");
        }
        else{
            erRepository.save(new EventRegistration(ui.get(), ei.get()));
        }
    }

    public void unregisterEvent(Long id, Long userId) {
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        Optional<UserInfo> ui = uiRepository.findUserInfoById(userId);
        if (!ei.isPresent())
            throw new IllegalStateException("Event with id " + id + " does not exist.");
        if (!ui.isPresent())
            throw new IllegalStateException("User with id " + userId + " does not exist.");

        Optional<EventRegistration> er = erRepository.findEventRegistrationByUserAndEvent(ui.get(), ei.get());
        if (er.isPresent()) {
            erRepository.delete(er.get());
        } else {
            throw new IllegalStateException("User with id " + userId + " is not registered the event with id " + id);
        }
    }

    public void updateEventName(Long id, Long HostID, String name){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setName(name);
        eiRepository.save(ei.get());
    }

    public void updateEventLocation(Long id, Long HostID, String loc){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setLocation(loc);
        eiRepository.save(ei.get());
    }

    public void updateEventCategory(Long id, Long HostID, String category){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setCategory(category);
        eiRepository.save(ei.get());
    }

    public void updateEventDate(Long id, Long HostID, LocalDate date){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setDate(date);
        eiRepository.save(ei.get());
    }

    public void updateEventTime(Long id, Long HostID, LocalTime time){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setTime(time);
        eiRepository.save(ei.get());
    }

    public void updateEventCap(Long id, Long HostID, int cap){
        Optional<EventInfo> ei = eiRepository.findEventInfoById(id);
        if(!ei.isPresent()){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        Long host_id = ei.get().getHostId();
        if(host_id != HostID)throw new IllegalStateException("Not allowed to modify the event");
        ei.get().setCapacity(cap);
        eiRepository.save(ei.get());
    }
}

