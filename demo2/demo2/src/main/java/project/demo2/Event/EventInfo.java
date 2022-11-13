package project.demo2.Event;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private int type;
    private int category;
    private LocalDate Date;
    private LocalTime time;
    private int capacity;

    public EventInfo() {
    }

    public EventInfo(Long id, String name, String location, int type, int category, LocalDate date, LocalTime time, int capacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.category = category;
        Date = date;
        this.time = time;
        this.capacity = capacity;
    }

    public EventInfo(String name, String location, int type, int category, LocalDate date, LocalTime time, int capacity) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.category = category;
        Date = date;
        this.time = time;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getType() {
        return type;
    }

    public int getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return Date;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "EventInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type=" + type +
                ", category=" + category +
                ", Date=" + Date +
                ", time=" + time +
                ", capacity=" + capacity +
                '}';
    }
}
