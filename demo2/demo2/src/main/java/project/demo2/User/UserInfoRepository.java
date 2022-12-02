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

    @Query("update UserInfo ui set ui.email = ?2 where ui.username = ?1")
    void updateEmail(String username, String email);

    @Query("update UserInfo ui set ui.firstName = ?2 where ui.username = ?1")
    void updateFN(String username, String fn);

    @Query("update UserInfo ui set ui.lastName = ?2 where ui.username = ?1")
    void updateLN(String username, String ln);

    @Query("update UserInfo ui set ui.userName = ?2 where ui.id = ?1")
    void updateUN(String username,Long id);
    @Query("select ui.id from UserInfo ui where ui.userName = ?1")
    Long findIdByUsername(String name);

}
