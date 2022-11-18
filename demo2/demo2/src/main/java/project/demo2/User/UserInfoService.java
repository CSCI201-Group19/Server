package project.demo2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoService {
    private final UserInfoRepository uiRepository;

    @Autowired
    public UserInfoService (UserInfoRepository uiRepository){
        this.uiRepository = uiRepository;
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
}
