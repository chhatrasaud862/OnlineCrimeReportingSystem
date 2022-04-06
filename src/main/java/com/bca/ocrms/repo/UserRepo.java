package com.bca.ocrms.repo;

import com.bca.ocrms.model.user.User;
import com.bca.ocrms.model.user.register.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Chhatra
 * @product IntelliJ IDEA
 * @project ocrms
 * @Date 4/5/22
 */
@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    public User findUserByEmail(String email);
}
