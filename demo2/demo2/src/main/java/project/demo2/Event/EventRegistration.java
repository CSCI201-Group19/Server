package project.demo2.Event;

import project.demo2.User.UserInfo;

import javax.persistence.*;

@Entity
public class EventRegistration {
    @EmbeddedId
    EventRegistrationKey id = new EventRegistrationKey();

    @ManyToOne
    @MapsId("userID")
    @JoinColumn(name = "user_id")
    UserInfo user;

    @ManyToOne
    @MapsId("eventID")
    @JoinColumn(name = "event_id")
    EventInfo event;

    public EventRegistration() {
    }

    public EventRegistration(EventRegistrationKey id, UserInfo user, EventInfo event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public EventRegistration(UserInfo user, EventInfo event) {
        this.user = user;
        this.event = event;
    }

    public EventRegistrationKey getId() {
        return id;
    }

    public void setId(EventRegistrationKey id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public EventInfo getEvent() {
        return event;
    }

    public void setEvent(EventInfo event) {
        this.event = event;
    }
}
