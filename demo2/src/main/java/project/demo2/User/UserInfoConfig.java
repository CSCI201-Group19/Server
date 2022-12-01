package project.demo2.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.demo2.User.UserInfoRepository;

import java.util.List;
@Configuration
public class UserInfoConfig {
    @Bean
    CommandLineRunner commandLineRunner2(UserInfoRepository repository){
        return args ->{
            UserInfo alex = new UserInfo("Alex", "alex123@usc.edu","alex1234alex", "Alex","xyz");
            UserInfo jason = new UserInfo("Jason", "jason456@usc.edu","jason1234","jason","abc");
            repository.saveAll(List.of(alex,jason));
        };

    }
}
