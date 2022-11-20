package com.jb.couponsystem.exception;

public class CouponSystemException  extends  Exception{

    public CouponSystemException(ErrMsg errorMsg) {
        super(errorMsg.getMassage());
    }
}
