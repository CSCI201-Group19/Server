package project.demo2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.demo2.Event.EventInfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping(path = "api/v1/UserInfo")

public class UserInfoController {
    private final UserInfoService uiService;

    @Autowired
    public UserInfoController(UserInfoService uiService){
        this.uiService = uiService;
    }
    @GetMapping
    public List<UserInfo> getUserInfo(){
        return uiService.getUserInfo();
    }
    @GetMapping(path = "/login")
    public Boolean UserLoginVerification(@RequestParam String userName, String password){
        return uiService.UserLoginVerification(userName,password);
    }
    @PostMapping(path = "/signup")
    public Boolean UserSignUp(@RequestBody UserInfo ui){
        return uiService.UserSignUp(ui);
    }

   

    @GetMapping(path = "/fetchProfile")
    public UserInfo fetchProfile (@RequestParam String userName){
        return uiService.UserProfile(userName);
    }

    @GetMapping(path = "/fetchEventByDateUser")
    public List<EventInfo> fetchEvent(@RequestParam LocalDate date, Long id){
        return uiService.UserEvents(date, id);

    }

}
