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

    public List<EventInfo> UserEvents(LocalDate date, String userName) {
        Optional<UserInfo> ui = uiRepository.findUserInfoByName(userName);
        Long id = ui.get().getId();
        List<EventInfo> temp = eventRepository.findEventInfoByHostID(id);
        return temp;

    }


    public List<EventInfo> UserEventsByNameCreated(String userName) {
        return eventRepository.findEventInfoByHostName(uiRepository.findUserInfoByName(userName).get().getUserName());
    }

    public void UserUpdateEmail(String username, String email)
    {
        uiRepository.updateEmail(username, email);
    }

    public void UserUpdateUsername(String username_, String username)
    {
        long id = uiRepository.findIdByUsername(username);
        uiRepository.updateUN(username_, id);
    }

    public void UserUpdateFirstName(String firstName, String username)
    {
        uiRepository.updateFN(username, firstName);
    }

    public void UserUpdateLastName(String lastName, String username)
    {
        uiRepository.updateLN(username, lastName);
    }
}
