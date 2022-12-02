package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class GuestPage {
    @GetMapping(path = "/guest")
    public String hello() {
        return "guest-page";
    }
}

