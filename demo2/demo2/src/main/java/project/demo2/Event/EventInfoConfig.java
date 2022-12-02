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
            EventInfo studyGroup = new EventInfo("Marco Papa OH", "PHE516", "Office Hour",
                    LocalDate.of(2022, Month.DECEMBER,9),
                    LocalTime.of(10,0,0),9999,4l,"Marco Papa");
            EventInfo presentation = new EventInfo("Presentation", "SAL109", "study",
                    LocalDate.of(2022, Month.DECEMBER,20),
                    LocalTime.of(15,0,0),150, 2l, "Jason");
            EventInfo coffeeChat = new EventInfo("Dance Club", "Lyon", "Work Out",
                    LocalDate.of(2022, Month.DECEMBER, 7),
                    LocalTime.of(8,0,0),40,3l,"Leon");
            EventInfo a = new EventInfo("CSCI201 Project", "THH 211", "study",
                    LocalDate.of(2022, Month.DECEMBER, 7),
                    LocalTime.of(22,0,0),8,3l,"Leon");
            EventInfo b = new EventInfo("Swimming Club", "Lyon", "Work Out",
                    LocalDate.of(2022, Month.DECEMBER, 7),
                    LocalTime.of(14,0,0),15,3l,"Leon");
            EventInfo c = new EventInfo("CSCI201 Lab", "SAL126", "study",
                    LocalDate.of(2022, Month.DECEMBER, 7),
                    LocalTime.of(18,0,0),35,3l,"Leon");
            EventInfo d = new EventInfo("Study Group", "Leavey", "study",
                    LocalDate.of(2022, Month.DECEMBER, 7),
                    LocalTime.of(20,0,0),5,3l,"Leon");

            repository.saveAll(List.of(studyGroup,presentation,coffeeChat,a,b,c,d));
        };

    }

}
