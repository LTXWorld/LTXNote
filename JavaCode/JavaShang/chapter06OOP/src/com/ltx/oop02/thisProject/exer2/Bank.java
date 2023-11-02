package com.ltx.oop02.thisProject.exer2;

/**
 * ClassName: Bank
 * Package:com.ltx.oop02.thisProject.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:52
 */
public class Bank {
    private Customer[] customers;
    private int numberOfCustomers;//记录客户的个数

    public Bank(){
        customers = new Customer[10];
    }

    /**
     * 将指定姓名的用户保存在银行的客户列表里
     * @param f
     * @param l
     */
    public void addCustomer(String f,String l){
        Customer customer = new Customer(f, l);
        customers[numberOfCustomers ++] = customer;
    }

    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    /**
     * 获取指定位置上的用户
     * @param index
     * @return
     */
    public Customer getCustomer(int index){
        if (index < 0 || index >= numberOfCustomers){
            return null;
        }
        return customers[index];
    }
}
