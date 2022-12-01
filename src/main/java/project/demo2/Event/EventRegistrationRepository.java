package project.demo2.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.demo2.User.UserInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRegistrationRepository
        extends JpaRepository<EventRegistration, Long> {
    @Query("select er from EventRegistration er where er.event = ?1")
    List<EventRegistration> findEventRegistrationByEvent(EventInfo eventInfo);

    @Query("select er from EventRegistration er where er.user = ?1")
    List<EventRegistration> findEventRegistrationByUser(UserInfo userInfo);

    @Query("select er from EventRegistration er where er.user = ?1 and er.event.date = ?2")
    List<EventRegistration> findEventRegistrationByUserAndDate(UserInfo userInfo, LocalDate date);

    @Query("select er from EventRegistration er where er.user = ?1 and er.event = ?2")
    Optional<EventRegistration> findEventRegistrationByUserAndEvent(UserInfo userInfo, EventInfo eventInfo);
}
