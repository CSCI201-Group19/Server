package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class EventListPage {
    @GetMapping(path = "/event-list")
    public String hello() {
        return "event-list";
    }
}
