package com.ltx.bank.web;

import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.exceptions.TransferException;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.service.impl.AccountServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: AccountServlet
 * Package:com.ltx.bank.web
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:23
 */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    //为了让此对象在其他方法中也可以使用，声明为实例变量
    private AccountService accountService = new AccountServiceimpl();//多态创建对象
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));//将money转为double类型进行接受
        //servlet作为中间桥梁(调度司令），不处理业务，调用service的方法来完成转账业务
        try {
            accountService.transfer(fromActno,toActno,money);
            //程序走到这里证明转账成功
            //调用视图层view完成展示结果
            resp.sendRedirect(req.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            resp.sendRedirect(req.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            resp.sendRedirect(req.getContextPath() + "/error2.html");
        }
    }
}
