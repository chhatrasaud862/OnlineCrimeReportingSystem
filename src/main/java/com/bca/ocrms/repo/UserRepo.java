package com.bca.ocrms.repo;

import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.register.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/5/22
 */
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findUserByEmail(String email);
    @Query(value = "SELECT * FROM tbl_user u WHERE u.user_id=?1 and u.userStatus = 1", nativeQuery = true)
    List<User> userList(Integer userId);
}
