package com.example.springbootthirdparty.service;

import com.example.springbootthirdparty.domain.SMSCode;

/**
 * ClassName: SMSCodeService
 * Package:com.example.springbootthirdparty.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/30 10:03
 */
public interface SMSCodeService {
    public String sendCodeToSMS(String tele);
    public boolean checkCode(SMSCode smsCode);
}
