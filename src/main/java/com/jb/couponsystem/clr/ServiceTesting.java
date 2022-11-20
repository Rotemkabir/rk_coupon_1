package com.jb.couponsystem.clr;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.service.AdminServiceImpl;
import com.jb.couponsystem.service.CompanyServiceImpl;
import com.jb.couponsystem.service.CustomerServiceImpl;
import com.jb.couponsystem.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(2)
public class ServiceTesting implements CommandLineRunner {

    @Autowired
    private AdminServiceImpl adminService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private CustomerServiceImpl customerService;

    @Override
    public void run(String... args) throws Exception {
        PrintUtils.title("Login admin - FAIL email/password");
        adminService.login("admi@admi.com", "admin");
        PrintUtils.title("Login admin - SUCCESS");
        adminService.login("admin@admin.com", "admin");
        PrintUtils.title("Add new company - FAIL name/email ");
        Company company1 = Company.builder()
                .name("BBB")
                .email("bbb@bbb.com")
                .password("bbb")
                .build();
        adminService.addCompany(company1);
        PrintUtils.title("Add new company - SUCCESS ");
        Company company2 = Company.builder()
                .name("coca-cola")
                .email("coca@cola.com")
                .password("ccc")
                .build();
        adminService.addCompany(company2);
        PrintUtils.title("Update exist company - FAIL name/id");
        Company c1 = adminService.getSingleCompany(2);
        c1.setName("company90");
        adminService.updateCompany(c1.getId(), c1);
        PrintUtils.title("Update exist company - SUCCESS");
        Company c2 = adminService.getSingleCompany(2);
        c2.setPassword("22222");
        adminService.updateCompany(c2.getId(), c2);
        adminService.getAllCompanies().forEach(System.out::println);
        PrintUtils.title("Delete company and company purchase coupon");
        adminService.deleteCompany(5);
        adminService.getAllCompanies().forEach(System.out::println);
        PrintUtils.title("get all companies");
        adminService.getAllCompanies().forEach(System.out::println);
        PrintUtils.title("Get single company");
        System.out.println(adminService.getSingleCompany(3));
        PrintUtils.title("Add new customer - FAIL email");
        Customer customer1 = Customer.builder()
                .firstName("harel")
                .lastName("kabir")
                .email("rotem@rotem.com")
                .password("harel")
                .build();
        adminService.addCustomer(customer1);
        PrintUtils.title("Add new customer - SUCCESS ");
        Customer customer2 = Customer.builder()
                .firstName("harel")
                .lastName("kabir")
                .email("harel@harel.com")
                .password("harel")
                .build();
        adminService.addCustomer(customer2);
        PrintUtils.title("Update exist customer - FAIL id");
        Customer s1 = adminService.getSingleCustomer(2);
        s1.setId(340);
        adminService.updateCustomer(s1.getId(), s1);
        PrintUtils.title("Update exist customer - SUCCESS");
        Customer s2 = adminService.getSingleCustomer(2);
        s1.setPassword("340");
        adminService.updateCustomer(s1.getId(), s1);
        adminService.getAllCustomers().forEach(System.out::println);
        PrintUtils.title("Delete customer and customer purchase coupon");
        adminService.deleteCustomer(4);
        adminService.getAllCustomers().forEach(System.out::println);
        PrintUtils.title("get all customers");
        adminService.getAllCustomers().forEach(System.out::println);
        PrintUtils.title("Get single customer");
        System.out.println(adminService.getSingleCustomer(3));
        System.out.println();
        System.out.println();
        PrintUtils.title("Login company - FAIL email/password");
        companyService.login("cc@cc.com","cc");
        PrintUtils.title("Login company - SUCCESS");
        companyService.login("bbb@bbb.com","bbb");
        PrintUtils.title("Add new coupon - FAIL title");
        Coupon p1 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("50%")
                .description("coupon6")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(50)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(5)))
                .amount(666)
                .price(600)
                .image("coupon6")
                .build();
        companyService.addCoupon(p1);
        PrintUtils.title("Add new coupon - SUCCESS");
        Coupon p2 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("60%")
                .description("coupon6")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(50)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(5)))
                .amount(666)
                .price(600)
                .image("coupon6")
                .build();
        companyService.addCoupon(p2);
        PrintUtils.title("Update exist coupon - FAIL coupon id/company id");
        Coupon p3 = companyService.getSingleCoupon(5);
        p3.setId(3);
        companyService.updateCoupon(p3.getId(), p3);
        PrintUtils.title("Update exist coupon - SUCCESS");
        Coupon p4 = companyService.getSingleCoupon(5);
        p4.setAmount(110);
        companyService.updateCoupon(p4.getId(), p4);
        System.out.println(companyService.getSingleCoupon(5));
        PrintUtils.title("Delete coupon and coupon purchase");
        companyService.deleteCoupon(5);
        PrintUtils.title("Get all coupons by company id");
        companyService.getAllCouponsByCompanyId(4).forEach(System.out::println);
        PrintUtils.title("Get all company coupons by specific category");
        companyService.getAllCompanyCouponsBySpecificCategory(5, Category.FOOD).forEach(System.out::println);
        PrintUtils.title("Get all company coupons by max price");
        companyService.getAllCompanyCouponByMaxPrice(1, 800.0).forEach(System.out::println);
        PrintUtils.title("Get details company");
        System.out.println(companyService.getCompanyDetails(5));
        System.out.println();
        System.out.println();
        PrintUtils.title("Login customer - FAIL email/password");
        customerService.login("kob@kob.com","cc");
        PrintUtils.title("Login customer - SUCCESS");
        customerService.login("kobi@kobi.com","kobi");
        PrintUtils.title("Purchase coupon - SUCCESS");
        Coupon p5 = customerService.getSingleCoupon(5);
        customerService.purchaseCoupon(p5);
        PrintUtils.title("All customer coupons");
        customerService.getCustomerCouponsById(5).forEach(System.out::println);
        PrintUtils.title("Get all customer coupons by specific category");
        customerService.getAllCustomerCouponsBySpecificCategory(5, Category.ELECTRICITY).forEach(System.out::println);
        PrintUtils.title("Get all customer coupons by max price");
        customerService.getAllCustomerCouponByMaxPrice(5, 660.0).forEach(System.out::println);
        PrintUtils.title("Get details customer");
        System.out.println(customerService.getCustomerDetails(5));

    }
}
