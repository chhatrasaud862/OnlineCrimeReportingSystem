package com.bca.ocrms.repo.user;

import com.bca.ocrms.dto.user.ComplainDto;
import com.bca.ocrms.model.user.complain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComplainRepo extends JpaRepository<Complain,Integer> {
    @Query(value = "SELECT * FROM user_complain u WHERE u.register_id = ?1 order by u.id", nativeQuery = true)
    List<Complain> getComplainList(Integer userId);

    @Query(value = "SELECT * FROM user_complain u WHERE u.register_id=?1 and u.complain_status=1",nativeQuery = true)
    List<Complain> getVerifiedStatus(Integer userId);

    @Query(value = "select count(uc.complain_status) from user_complain uc",nativeQuery = true)
    int getTotalComplain();

    @Query(value = "select count(uc.complain_status)from user_complain uc where uc.complain_status= 0",nativeQuery = true)
    String getPendingComplain();

    @Query(value = "select count(uc.complain_status)from user_complain uc where uc.complain_status=1",nativeQuery = true)
    String getApproveComplain();

    @Query(value = "select * from user_complain u  order by u.id",nativeQuery = true)
    List<Complain> getComplainDetails();

   /* @Modifying
    @Query(value = "update Complain uc  set uc.complainStatus = 1 where  uc.id= :id")
    void setUpdateStatus(@Param("complainStatus") String complain_status, @Param("id") Integer id);*/
}
