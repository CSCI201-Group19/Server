package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CreateEventPage {
    @GetMapping(path = "/create-event")
    public String hello() {
        return "create-event-page";
    }
}
