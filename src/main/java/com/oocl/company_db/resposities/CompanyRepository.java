package com.oocl.company_db.resposities;

import com.oocl.company_db.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository <Company,Long>{
}
