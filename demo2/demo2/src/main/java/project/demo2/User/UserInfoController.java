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
    public List<EventInfo> fetchEvent(@RequestParam LocalDate date, String userName){
        return uiService.UserEvents(date, userName);

    }



    @GetMapping(path = "/fetchEventByUserCreate")
    public List<EventInfo> fetchEventCreated(@RequestParam String userName){
        return uiService.UserEventsByNameCreated(userName);

    }

    @PutMapping(path = "/updateEmail/{userName}/{email}")
    public void updateEmail(@PathVariable("userName") String userName, @PathVariable("email") String email)
    {
        uiService.UserUpdateEmail(userName,email);
    }

    @PutMapping(path = "/updateUsername/{userName}/{newUserName}")
    public void updateUsername(@PathVariable("userName") String userName, @PathVariable("newUserName") String newUserName) //userName_ is the input field, userName is the original username
    {
        uiService.UserUpdateUsername(newUserName, userName);
    }

    @PutMapping(path = "/updateFirstName/{userName}/{firstName}")
    public void updateFirstName(@PathVariable("userName") String userName, @PathVariable("firstName") String firstName)
    {
        uiService.UserUpdateFirstName(firstName,userName);
    }

    @PutMapping(path = "/updateLastName/{userName}/{lastName}")
    public void updateLastName(@PathVariable("userName") String userName, @PathVariable("lastName") String lastName)
    {
        uiService.UserUpdateLastName(lastName,userName);
    }
}
