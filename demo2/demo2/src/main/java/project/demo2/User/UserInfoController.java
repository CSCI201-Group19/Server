package project.demo2.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping(path = "login")
    public Boolean UserLoginVerification(@RequestBody UserLogin ul){
        return uiService.UserLoginVerification(ul.getUserName(),ul.getPassword());
    }
}
