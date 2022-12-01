package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RegisterPage {
    @GetMapping(path = "/register")
    public String hello() {
        return "register-page";
    }
}
