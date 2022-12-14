package project.demo2.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    @Modifying
    @Query(value = "insert into event_registration (event_id, user_id) values (:userid, :eventid)", nativeQuery = true)
    void addEventRegistrationByUserIdAndEventId(@Param("userid") Long userID, @Param("eventid") Long eventID);
}
