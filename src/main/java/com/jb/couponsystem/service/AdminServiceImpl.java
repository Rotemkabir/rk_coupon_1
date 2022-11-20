package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.exception.CouponSystemException;
import com.jb.couponsystem.exception.ErrMsg;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {

    @Override
    public boolean login(String email, String password) throws CouponSystemException {
//        if (!(email.equalsIgnoreCase("admin@admin.com") && password.equalsIgnoreCase("admin"))) {
//            throw new CouponSystemException(ErrMsg.EMAIL_OR_PASSWORD_WRONG);
//        }
        System.out.println("Hello admin! you logged in!");
        return true;
    }

    @Override
    public void addCompany(Company company) throws CouponSystemException {
        if (this.companyRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
            throw new CouponSystemException(ErrMsg.NAME_OR_EMAIL_ALREADY_EXIST);
        }
        this.companyRepository.save(company);
    }

    @Override
    public void updateCompany(int companyId, Company company) throws CouponSystemException {
        if (!this.companyRepository.existsById(companyId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        if (companyId != company.getId()) {
            throw new CouponSystemException(ErrMsg.CANNOT_UPDATE_COMPANY_ID_OR_NAME);
        }
        // TODO: 11/16/2022
        /*חסר תנאי -אסור לעדכן שם חברה!!!!!!!!!*/
        company.setId(companyId);
        this.companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!this.companyRepository.existsById(companyId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        // TODO: 11/16/2022
        /*לבדוק עם שקד את שאילתה מחיקת קופונים לפי תז!!!!*/
        this.couponRepository.deletePurchaseCouponByCompanyId(companyId);
        this.companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        return this.companyRepository.findById(companyId)
                .orElseThrow(() -> new CouponSystemException(ErrMsg.ID_NOT_EXIST));
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if (this.customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.EMAIL_ALREADY_EXIST);
        }
        this.customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        if (customerId != customer.getId()) {
            throw new CouponSystemException(ErrMsg.CANNOT_UPDATE_CUSTOMER_ID);
        }
        customer.setId(customerId);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrMsg.ID_NOT_EXIST);
        }
        // TODO: 11/16/2022
        /*לבדוק עם שקד את שאילתה מחיקת קופונים לפי תז!!!!*/
        this.couponRepository.deletePurchaseCouponByCustomerId(customerId);
        this.customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws CouponSystemException {
        return this.customerRepository.findById(customerId)
                .orElseThrow(() -> new CouponSystemException(ErrMsg.ID_NOT_EXIST));
    }
}
