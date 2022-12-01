package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CalendarPage {
    @GetMapping(path = "/calendar")
    public String hello() {
        return "calendar-page";
    }
}
