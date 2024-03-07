package com.powernode.spring6.service;

import com.powernode.spring6.dao.OrderDao;

/**
 * ClassName: OrderService
 * Package:com.powernode.spring6.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/6 15:07
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}
