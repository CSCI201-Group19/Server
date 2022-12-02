package project.demo2.Event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.demo2.User.UserInfoConfig;
import project.demo2.User.UserInfoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class EventRegistrationConfig {
    @Bean
    CommandLineRunner commandLineRunnerER(EventRegistrationRepository repository){
        return args -> {
            repository.addEventRegistrationByUserIdAndEventId(1l, 4l);
            repository.addEventRegistrationByUserIdAndEventId(2l, 2l);
            repository.addEventRegistrationByUserIdAndEventId(3l, 3l);
            repository.addEventRegistrationByUserIdAndEventId(4l, 3l);
            repository.addEventRegistrationByUserIdAndEventId(5l, 3l);
            repository.addEventRegistrationByUserIdAndEventId(6l, 3l);
            repository.addEventRegistrationByUserIdAndEventId(7l, 3l);
            repository.addEventRegistrationByUserIdAndEventId(8l, 3l);



        };

    }

}
