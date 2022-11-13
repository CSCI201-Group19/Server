package project.demo2.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class UserInfo {
    @Id
    @SequenceGenerator(
            name = "UserInfo_sequence", sequenceName = "UserInfo_sequence", allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "UserInfo_sequence"
    )
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String major;
    private String schoolYear;
    private String Interests;

    public UserInfo() {
    }

    public UserInfo(Long id, String userName, String email, String password, String major, String schoolYear, String interests) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.major = major;
        this.schoolYear = schoolYear;
        Interests = interests;
    }

    public UserInfo(String userName, String email, String password, String major, String schoolYear, String interests) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.major = major;
        this.schoolYear = schoolYear;
        Interests = interests;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMajor() {
        return major;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getInterests() {
        return Interests;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", major='" + major + '\'' +
                ", schoolYear='" + schoolYear + '\'' +
                ", Interests='" + Interests + '\'' +
                '}';
    }
}
