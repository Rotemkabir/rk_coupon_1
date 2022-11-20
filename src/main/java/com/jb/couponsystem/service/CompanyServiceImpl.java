package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.exception.CouponSystemException;
import com.jb.couponsystem.exception.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ClientService implements CompanyService {


    @Override
    public boolean login(String email, String password) throws CouponSystemException {
        if (!this.companyRepository.existsByEmailAndPassword(email, password)) {
            throw new CouponSystemException(ErrMsg.EMAIL_OR_PASSWORD_WRONG);
        }
        /*לבדוק את שורה 22*/
        /*this.companyId = companyDAO.findCompanyByEmail(email).getId();*/
        System.out.println("Hello company ! you logged in !");
        return true;
    }

    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if (this.couponRepository.isCouponExistByTitle(coupon.getTitle())) {
            throw new CouponSystemException(ErrMsg.COUPON_TITLE_ALREADY_EXIST);
        }
        this.couponRepository.save(coupon);
        System.out.println("coupon added !");
    }

    @Override
    public void updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        if (couponId != coupon.getId()) {
            throw new CouponSystemException(ErrMsg.CANNOT_UPDATE_COUPON_OR_COMPANY_ID);
        }
        // TODO: 11/16/2022
        /*חסר תנאי -אסור לעדכן שם חברה!!!!!!!!!*/
        coupon.setId(couponId);
        this.couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        // TODO: 11/16/2022
        /*לבדוק עם שקד את שאילתה מחיקת היסטורית קופונים!!!!*/
        this.couponRepository.deletePurchaseCouponByCouponId(couponId);
        this.couponRepository.deleteById(couponId);
    }

    @Override
    public Coupon getSingleCoupon(int couponId) throws CouponSystemException {
        return this.couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponSystemException(ErrMsg.ID_NOT_EXIST));
    }

    @Override
    public List<Coupon> getAllCouponsByCompanyId(int companyId) {
        return this.couponRepository.findByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getAllCompanyCouponsBySpecificCategory(int companyId, Category category) {
        return this.couponRepository.findCompanyCouponsBySpecificCategory(companyId, category);
    }

    @Override
    public List<Coupon> getAllCompanyCouponByMaxPrice(int companyId, double maxPrice) {
        return this.couponRepository.findByPriceLessThan(companyId, maxPrice);
    }

    @Override
    public Company getCompanyDetails(int companyId) {
        return this.companyRepository.getDetails(companyId);
    }
}
