package project.demo2.Event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Configuration
public class EventInfoConfig {
    @Bean
    CommandLineRunner commandLineRunner(EventInfoRepository repository){
        return args -> {
            EventInfo studyGroup = new EventInfo("Study Group", "THH101", "study",
                    LocalDate.of(2022, Month.NOVEMBER,15),
                    LocalTime.of(10,0,0),10,1l);
            EventInfo presentation = new EventInfo("Presentation", "SAL109", "study",
                    LocalDate.of(2022, Month.DECEMBER,20),
                    LocalTime.of(15,0,0),150, 2l);
            EventInfo coffeeChat = new EventInfo("Coffee Chat", "StarBucks", "study",
                    LocalDate.of(2022, Month.DECEMBER, 1),
                    LocalTime.of(20,0,0),3,3l);

            repository.saveAll(List.of(studyGroup,presentation,coffeeChat));
        };

    }

}
