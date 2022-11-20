package com.jb.couponsystem.security;

import com.jb.couponsystem.exception.CouponSystemException;
import com.jb.couponsystem.exception.ErrMsg;
import com.jb.couponsystem.service.*;
import org.springframework.stereotype.Service;


@Service
public class LoginManager {

    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case ADMINISTRATOR:
                AdminServiceImpl adminService = new AdminServiceImpl();
                if (adminService.login(email, password)) {
                    return adminService;
                }
            case COMPANY:
                CompanyServiceImpl companyService  = new CompanyServiceImpl();
                if (companyService.login(email, password)) {
                    return companyService;
                }
            case CUSTOMER:
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                if (customerService.login(email, password)) {
                    return customerService;
                }
                break;
            default:
                throw new CouponSystemException(ErrMsg.EMAIL_OR_PASSWORD_WRONG);
        }
        return null;
    }


}
