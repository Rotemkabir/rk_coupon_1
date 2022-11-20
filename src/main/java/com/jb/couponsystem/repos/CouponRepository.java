package com.jb.couponsystem.repos;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    List<Coupon> findByCompanyId(int companyId);

    List<Coupon> findByPriceLessThan(int companyId, double maxPrice);

    List<Coupon> findByPriceLessThan2(int customerId, double maxPrice);

    @Query(value = "select * from coupons where company_id = ? and category_id = ?", nativeQuery = true)
    List<Coupon> findCompanyCouponsBySpecificCategory(int companyId, Category category);

    // TODO: 11/16/2022
    /* JOIN -לבדוק עם שקד*/
    /*SELECT * FROM `java-151-project-l1`.`coupons` JOIN `java-151-project-l1`.`customers_vs_coupons` ON
     `java-151-project-l1`.`coupons`.id = `java-151-project-l1`.`customers_vs_coupons`.coupon_id WHERE
      (`java-151-project-l1`.`customers_vs_coupons`.`customer_id` = ?) AND
       (`java-151-project-l1`.`coupons`.`category_id`= ?)*/
    @Query(value = "select * from customers_vs_coupons where customer_id = ?", nativeQuery = true)
    List<Coupon> findCustomerCouponsBySpecificCategory(int customerId, Category category);

    @Query(value = "delete * from coupons where company_id = ?", nativeQuery = true)
    void deletePurchaseCouponByCompanyId(int companyId);

    @Query(value = "delete * from customers_vs_coupons where customer_id = ?", nativeQuery = true)
    void deletePurchaseCouponByCustomerId(int customerId);

    @Query(value = "delete * from customers_vs_coupons where coupon_id = ?", nativeQuery = true)
    void deletePurchaseCouponByCouponId(int couponId);

    @Query(value = "select * from coupons where title = ?", nativeQuery = true)
    boolean isCouponExistByTitle(String title);
}
