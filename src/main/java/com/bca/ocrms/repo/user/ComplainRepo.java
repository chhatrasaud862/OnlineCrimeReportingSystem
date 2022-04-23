package com.bca.ocrms.repo.user;

import com.bca.ocrms.model.user.complain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainRepo extends JpaRepository<Complain,Integer> {
    @Query(value = "SELECT * FROM user_complain u WHERE u.register_id = ?1", nativeQuery = true)
    List<Complain> getComplainList(Integer userId);

    @Query(value = "SELECT * FROM user_complain u WHERE u.register_id=?1 and u.complain_status=1",nativeQuery = true)
    List<Complain> getVerifiedStatus(Integer userId);
}
