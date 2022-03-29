package com.bca.ocrms.repo.user;

import com.bca.ocrms.model.user.register.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<Register,Integer> {
}
