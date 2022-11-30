package project.demo2.Event;

import project.demo2.User.UserInfo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table
public class EventInfo {
    @Id
    @SequenceGenerator(
        name = "EventInfo_sequence", sequenceName = "EventInfo_sequence", allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "EventInfo_sequence"
    )
    private Long id;
    private String name;
    private String location;
    private String category;
    private LocalDate date;
    private LocalTime time;
    private int capacity;
    private Long hostId;



    public EventInfo() {
    }

    public EventInfo(String name, String location, String category, LocalDate date, LocalTime time, int capacity, Long hostId) {
        this.name = name;
        this.location = location;
        this.category = category;
        this.date = date;
        this.time = time;
        this.capacity = capacity;
        this.hostId = hostId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", capacity=" + capacity +
                ", hostId=" + hostId +
                '}';
    }
}
