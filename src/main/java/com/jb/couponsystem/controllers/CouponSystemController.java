package com.jb.couponsystem.controllers;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.exception.CouponSystemException;
import com.jb.couponsystem.service.AdminService;
import com.jb.couponsystem.service.CompanyService;
import com.jb.couponsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/couponSystem")
public class CouponSystemController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;

    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCompany(@RequestBody Company company) throws CouponSystemException {
        adminService.addCompany(company);
    }

    @PutMapping("companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCompany(@PathVariable int id, @RequestBody Company company) throws CouponSystemException {
        adminService.updateCompany(id, company);
    }

    @DeleteMapping("companies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CouponSystemException {
        adminService.deleteCompany(id);
    }

    @GetMapping("companies")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("companies/{id}")
    public Company getSingleCompany(@PathVariable int id) throws CouponSystemException {
        return adminService.getSingleCompany(id);
    }

    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws CouponSystemException {
        adminService.addCustomer(customer);
    }

    @PutMapping("customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws CouponSystemException {
        adminService.updateCustomer(id, customer);
    }

    @DeleteMapping("customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CouponSystemException {
        adminService.deleteCustomer(id);
    }

    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("customers/{id}")
    public Customer getSingleCustomer(@PathVariable int id) throws CouponSystemException {
        return adminService.getSingleCustomer(id);
    }

    @PostMapping("coupons")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
        companyService.addCoupon(coupon);
    }

    @PutMapping("coupons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponSystemException {
        companyService.updateCoupon(id, coupon);
    }

    @DeleteMapping("coupons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int id) throws CouponSystemException {
        companyService.deleteCoupon(id);
    }

    @GetMapping("coupons/{id}")
    public Coupon getSingleCoupon(@PathVariable int id) throws CouponSystemException {
        return companyService.getSingleCoupon(id);
    }

    @GetMapping("coupons/company_id")
    public List<Coupon> getAllCouponsByCompanyId(@PathVariable int id) {
        return companyService.getAllCouponsByCompanyId(id);
    }

    @GetMapping("coupons/company_id/category")
    public List<Coupon> getAllCompanyCouponsBySpecificCategory(@PathVariable int id, @RequestParam String category) {
        return companyService.getAllCompanyCouponsBySpecificCategory(id, Category.valueOf(category));
    }

    @GetMapping("coupons/company_id/price")
    public List<Coupon> getAllCompanyCouponByMaxPrice(@PathVariable int id, @RequestParam double maxPrice) {
        return companyService.getAllCompanyCouponByMaxPrice(id, maxPrice);
    }

    @GetMapping("companies/{id}")
    public Company getCompanyDetails(@PathVariable int id) {
        return companyService.getCompanyDetails(id);
    }

    // TODO: 11/17/2022
    /*חסר מתודות של customer*/
}
