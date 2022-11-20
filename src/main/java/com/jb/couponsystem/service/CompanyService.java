package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.exception.CouponSystemException;

import java.util.List;

public interface CompanyService {

    boolean login(String email, String password) throws CouponSystemException;
    void addCoupon(Coupon coupon) throws CouponSystemException;
    void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException;
    void deleteCoupon(int couponId) throws CouponSystemException;
    Coupon getSingleCoupon(int couponId) throws CouponSystemException;
    List<Coupon> getAllCouponsByCompanyId(int companyId);
    List<Coupon> getAllCompanyCouponsBySpecificCategory(int companyId, Category category);
    List<Coupon> getAllCompanyCouponByMaxPrice(int companyId, double maxPrice);
    Company getCompanyDetails(int companyId);
}
