package project.demo2.Event;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EventRegistrationKey implements Serializable {
    @Column(name = "user_id")
    Long userID;

    @Column(name = "event_id")
    Long eventID;

    public EventRegistrationKey() {
    }

    public EventRegistrationKey(Long userID, Long eventID) {
        this.userID = userID;
        this.eventID = eventID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    @Override
    public String toString() {
        return "EventRegistrationKey{" +
                "userID=" + userID +
                ", eventID=" + eventID +
                '}';
    }
}
