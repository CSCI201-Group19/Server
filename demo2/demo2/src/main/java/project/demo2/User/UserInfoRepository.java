package project.demo2.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.demo2.User.UserInfo;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {


    @Query("select ui from UserInfo ui where ui.id = ?1")
    Optional<UserInfo> findUserInfoById(Long id);
    @Query("select ui from UserInfo ui where ui.userName = ?1")
    Optional<UserInfo> findUserInfoByName(String name);
    @Query("select ui.password from UserInfo ui where ui.userName = ?1")
    Optional<String> findUserPasswordByName(String name);
    @Query("select ui.email from UserInfo ui where ui.email = ?1")
    Optional<String> findEmail(String email);

}
