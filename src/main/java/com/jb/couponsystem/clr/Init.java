package com.jb.couponsystem.clr;

import com.jb.couponsystem.beans.Category;
import com.jb.couponsystem.beans.Company;
import com.jb.couponsystem.beans.Coupon;
import com.jb.couponsystem.beans.Customer;
import com.jb.couponsystem.repos.CompanyRepository;
import com.jb.couponsystem.repos.CouponRepository;
import com.jb.couponsystem.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public void run(String... args) throws Exception {
        Coupon coupon1 = Coupon.builder()
                .category(Category.FOOD)
                .title("10%")
                .description("coupon1")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(30)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(4)))
                .amount(111)
                .price(100)
                .image("coupon1")
                .build();
        Coupon coupon2 = Coupon.builder()
                .category(Category.ELECTRICITY)
                .title("20%")
                .description("coupon2")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(20)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(6)))
                .amount(222)
                .price(200)
                .image("coupon2")
                .build();
        Coupon coupon3 = Coupon.builder()
                .category(Category.RESTAURANT)
                .title("30%")
                .description("coupon3")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(80)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
                .amount(333)
                .price(300)
                .image("coupon3")
                .build();
        Coupon coupon4 = Coupon.builder()
                .category(Category.VACATION)
                .title("40%")
                .description("coupon4")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(40)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(4)))
                .amount(444)
                .price(400)
                .image("coupon4")
                .build();
        Coupon coupon5 = Coupon.builder()
                .category(Category.FOOD)
                .title("50%")
                .description("coupon5")
                .startDate(Date.valueOf(LocalDate.now().minusWeeks(50)))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(5)))
                .amount(555)
                .price(500)
                .image("coupon5")
                .build();

        Company company1 = Company.builder()
                .name("BBB")
                .email("bbb@bbb.com")
                .password("bbb")
                /*.coupon(List.of(coupon1,coupon5))*/
                .build();
        Company company2 = Company.builder()
                .name("Electric")
                .email("electric@electric.com")
                .password("electric")
                /*.coupon(List.of(coupon2))*/
                .build();
        Company company3 = Company.builder()
                .name("Pasta basta")
                .email("pasta@pasta.com")
                .password("pasta")
                /*.coupon(List.of(coupon3))*/
                .build();
        Company company4 = Company.builder()
                .name("fattal hotels")
                .email("fattal@fattal.com")
                .password("fattal")
                /*.coupon(List.of(coupon4))*/
                .build();

        Customer customer1 = Customer.builder()
                .firstName("kobi")
                .lastName("shasha")
                .email("kobi@kobi.com")
                .password("kobi")
                /*.coupon(List.of(coupon1, coupon5))*/
                .build();
        Customer customer2 = Customer.builder()
                .firstName("rotem")
                .lastName("kabir")
                .email("rotem@rotem.com")
                .password("rotem")
                /*.coupon(List.of(coupon4, coupon1))*/
                .build();
        Customer customer3 = Customer.builder()
                .firstName("menachem")
                .lastName("bussi")
                .email("menachem@menachem.com")
                .password("menachem")
                /*.coupon(List.of(coupon3, coupon2))*/
                .build();
        Customer customer4 = Customer.builder()
                .firstName("ella")
                .lastName("adler")
                .email("ella@ella.com")
                .password("ella")
                /*.coupon(List.of(coupon4, coupon5))*/
                .build();
        Customer customer5 = Customer.builder()
                .firstName("zvi")
                .lastName("hendel")
                .email("zvi@zvi.com")
                .password("zvi")
                /*.coupon(List.of(coupon3, coupon1))*/
                .build();

        coupon1.setCompany(company1);
        coupon5.setCompany(company1);
        coupon2.setCompany(company2);
        coupon3.setCompany(company3);
        coupon4.setCompany(company4);

        companyRepository.saveAll(List.of(company1, company2, company3, company4));
        companyRepository.findAll().forEach(System.out::println);
    }
}
