package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.exception.CouponSystemException;

import java.util.List;

public interface CustomerService {

    boolean login(String email, String password) throws CouponSystemException;
    void purchaseCoupon(Coupon coupon) throws CouponSystemException;
    Coupon getSingleCoupon(int couponId) throws CouponSystemException;
    List<Coupon> getCustomerCouponsById(int customerId);
    List<Coupon> getAllCustomerCouponsBySpecificCategory(int customerId, Category category);
    List<Coupon> getAllCustomerCouponByMaxPrice(int customerId, double maxPrice);
    Customer getCustomerDetails(int customerId) ;
}
