package com.jb.couponsystem.service;

import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.exception.CouponSystemException;

import java.util.List;

public interface AdminService {

    boolean login(String email, String password) throws CouponSystemException;
    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(int companyId, Company company) throws CouponSystemException;
    void deleteCompany(int companyId) throws CouponSystemException;
    List<Company> getAllCompanies();
    Company getSingleCompany(int companyId) throws CouponSystemException;
    void addCustomer(Customer customer) throws CouponSystemException;
    void updateCustomer(int customerId, Customer customer) throws CouponSystemException;
    void deleteCustomer(int customerId) throws CouponSystemException;
    List<Customer>getAllCustomers();
    Customer getSingleCustomer(int customerId) throws CouponSystemException;

}
