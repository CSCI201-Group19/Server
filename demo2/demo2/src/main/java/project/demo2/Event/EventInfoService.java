package project.demo2.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
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
    public void addNewEvent(EventInfo ei){
        Optional<EventInfo> eio = eiRepository.findEventInfoByName(ei.getName());
        if(eio.isPresent()){
            throw new IllegalStateException("Event existed");
        }
        eiRepository.save(ei);

    }
    public void deleteEvent(Long id){
        boolean exists = eiRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Event with id "+ id + " does not exist.");
        }
        eiRepository.deleteById(id);
    }
}

