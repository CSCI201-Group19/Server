package project.demo2.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class DemoPage {
    @GetMapping(path = "/demo")
    public String hello() {
        return "demo";
    }
}
