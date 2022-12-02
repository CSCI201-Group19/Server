package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginPage {
    @GetMapping(path = "/")
    public String hello() {
        return "login-page";
    }
}
