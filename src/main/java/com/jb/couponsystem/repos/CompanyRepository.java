package com.jb.couponsystem.repos;

import com.jb.couponsystem.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByNameOrEmail(String name, String email);

    boolean existsByEmailAndPassword(String email, String password);

    @Query(value = "select * from companies where id = ?", nativeQuery = true)
    Company getDetails(int companyId);


}
