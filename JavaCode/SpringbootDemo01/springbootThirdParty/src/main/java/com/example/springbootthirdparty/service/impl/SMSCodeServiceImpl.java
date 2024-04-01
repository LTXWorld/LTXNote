package com.example.springbootthirdparty.service.impl;

import com.example.springbootthirdparty.domain.SMSCode;
import com.example.springbootthirdparty.service.SMSCodeService;

/**
 * ClassName: SMSCodeServiceImpl
 * Package:com.example.springbootthirdparty.service.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/30 10:05
 */
public class SMSCodeServiceImpl implements SMSCodeService {
    @Override
    public String sendCodeToSMS(String tele) {
        return null;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        return false;
    }
}
