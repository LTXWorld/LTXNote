package com.BigProject1.service;

/**
 * ClassName: TeamException
 * Package:com.BigProject1.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 16:19
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -3387516993124228848L;
    public TeamException(String message) {
        super(message);
    }

    public TeamException() {
    }
}
