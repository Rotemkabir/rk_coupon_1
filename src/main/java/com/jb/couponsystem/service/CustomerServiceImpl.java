package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.exception.CouponSystemException;
import com.jb.couponsystem.exception.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends ClientService implements CustomerService {

    @Override
    public boolean login(String email, String password) throws CouponSystemException {
        if (!this.customerRepository.existsByEmailAndPassword(email, password)) {
            throw new CouponSystemException(ErrMsg.EMAIL_OR_PASSWORD_WRONG);
        }
        /*לבדוק את שורה 23*/
        /*this.companyId = companyDAO.findCompanyByEmail(email).getId();*/
        System.out.println("Hello customer ! you logged in !");
        return true;
    }

    @Override
    public void purchaseCoupon(Coupon coupon) throws CouponSystemException {
        // TODO: 11/16/2022
//        for (Coupon cou : couponRepository.findAllById()) {
//            if ((cou.getTitle().equalsIgnoreCase(coupon.getTitle()))) {
//                throw new CouponSystemException(ErrMsg.COUPON_ALREADY_PURCHASE);
//            }
//        }
//        if (coupon.getAmount() == 0) {
//            throw new CouponSystemException(ErrMsg.NO_MORE_FROM_SELECTED_COUPON);
//        }
//        if (Objects.equals(coupon.getEndDate(), Date.valueOf(LocalDate.now()))) {
//            throw new CouponSystemException(ErrMsg.COUPON_EXPIRED);
//        }
//        couponsDAO.addCouponPurchase(this.customerId, coupon.getId());
//        coupon.setAmount(coupon.getAmount() - 1);
//        System.out.println("coupon purchase !");
    }

    @Override
    public Coupon getSingleCoupon(int couponId) throws CouponSystemException {
        return this.couponRepository.findById(couponId)
                .orElseThrow(() -> new CouponSystemException(ErrMsg.ID_NOT_EXIST));
    }

    @Override
    public List<Coupon> getCustomerCouponsById(int customerId) {
        // TODO: 11/16/2022
        return null;
    }

    @Override
    public List<Coupon> getAllCustomerCouponsBySpecificCategory(int customerId, Category category) {
        return this.couponRepository.findCustomerCouponsBySpecificCategory(customerId, category);
    }

    @Override
    public List<Coupon> getAllCustomerCouponByMaxPrice(int customerId, double maxPrice) {
        return this.couponRepository.findByPriceLessThan2(customerId, maxPrice);
    }

    @Override
    public Customer getCustomerDetails(int customerId) {
        return this.customerRepository.getDetails(customerId);
    }
}
