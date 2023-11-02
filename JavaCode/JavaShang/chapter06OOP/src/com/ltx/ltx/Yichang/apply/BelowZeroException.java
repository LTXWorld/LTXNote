package com.ltx.ltx.Yichang.apply;

/**
 * ClassName: BelowZeroException
 * Package:com.ltx.Yichang.apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 10:21
 */
public class BelowZeroException extends Exception{
    static final long serialVersionUID = -3387516993124228848L;
    public BelowZeroException(String message) {
        super(message);
    }

    public BelowZeroException() {
    }
}
