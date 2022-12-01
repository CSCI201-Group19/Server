package project.demo2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.demo2.Event.EventInfo;
import project.demo2.Event.EventInfoRepository;
import project.demo2.Event.EventInfoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {
    private final UserInfoRepository uiRepository;
    private final EventInfoRepository eventRepository;

    @Autowired
    public UserInfoService (UserInfoRepository uiRepository, EventInfoRepository es){
        this.uiRepository = uiRepository;
        this.eventRepository = es;
    }
    public List<UserInfo> getUserInfo(){
        return uiRepository.findAll();
    }
    public Boolean UserLoginVerification(String name, String password){
        Optional<String> temp = uiRepository.findUserPasswordByName(name);
        if(temp.isPresent()&&temp.get().equals(password)){
            return true;
        }
        return false;
    }
    public Boolean UserSignUp(UserInfo ui){
        Optional<String> temp = uiRepository.findEmail(ui.getEmail());
        if(temp.isPresent()){
            return false;
        }
        uiRepository.save(ui);
        return true;

    }

    public UserInfo UserProfile(String userName) {
        Optional<UserInfo> temp = uiRepository.findUserInfoByName(userName);
        if(temp.isPresent()){
           return uiRepository.findUserInfoByName(userName).get();
        }
        return null;
    }

    public List<EventInfo> UserEvents(LocalDate date, Long id) {
        List<EventInfo> temp = eventRepository.findEventInfoByHostID(id);
        List<EventInfo> returnV = new ArrayList<EventInfo>();
        for(int i=1; i<temp.size();i++){
            if(temp.get(i).getDate().equals(date))
                returnV.add(temp.get(i));
        }
        return returnV;


    }
}
