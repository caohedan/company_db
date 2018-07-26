package com.oocl.company_db.n.to.n.resposities;

import com.oocl.company_db.n.to.n.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResposity extends JpaRepository <User,Long>{
}
