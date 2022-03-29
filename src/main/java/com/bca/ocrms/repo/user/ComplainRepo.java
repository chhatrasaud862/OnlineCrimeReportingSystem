package com.bca.ocrms.repo.user;

import com.bca.ocrms.model.user.complain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainRepo extends JpaRepository<Complain,Integer> {
    @Query(value = "SELECT * FROM user_complain u WHERE R.Register_id = ?1", nativeQuery = true)
    List<Complain> getComplainList(Integer userId);
}
