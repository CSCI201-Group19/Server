package project.demo2.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventInfoRepository
        extends JpaRepository<EventInfo,Long> {

    @Query("select ei from EventInfo ei where ei.name = ?1")
    Optional<EventInfo> findEventInfoByName(String name);

    @Query("select ei from EventInfo ei where ei.category = ?1")
    List<EventInfo> findEventInfoByCategory(int category);

    @Query("select ei from EventInfo ei where ei.type = ?1")
    List<EventInfo> findEventInfoByType(int type);


}
