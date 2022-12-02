package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfileEditPage {
    @GetMapping(path = "/profile-edit")
    public String hello() {
        return "profile-page-edit-information";
    }
}
