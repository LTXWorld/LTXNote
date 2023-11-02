package com.ltx.oop02.Project01.model;



/**
 * ClassName: CustomerList
 * Package:com.ltx.oop02.Project01.model
 * Description:
 *用来管理customer对象，使用数组来管理
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 16:38
 */
public class CustomerList {
    private Customer01[] customer01s;
    private int total;

    /**
     * 初始化用户数组
     * @param totalCustomer 表示最大长度
     */
    public CustomerList(int totalCustomer){
        customer01s = new Customer01[totalCustomer];
    }

    /**
     * 将customer01加到当前数组最后
     * @param customer01
     * @return 如果数组已满返回false
     */
    public boolean addCustomer(Customer01 customer01){
        if(total < customer01s.length){
            customer01s[total ++] = customer01;
            return true;
        }
        return false;
    }

    /**
     * 用后一个参数来替代index位置上原有的客户对象
     * @param index
     * @param cust
     * @return
     */
    public boolean replaceCustomer(int index,Customer01 cust){
        if(index >= 0 && index < total){
            customer01s[index] = cust;
            return true;
        }
        return false;
    }

    /**
     * 删除index位置上的元素,将有效数据最后一个位置置空
     * @param index
     * @return
     */
    public boolean deleteCustomer(int index){
        if(index >= 0 && index < total){
            for (int i = index; i < total - 1; i++) {
                customer01s[i] = customer01s[i + 1];
            }
            customer01s[total - 1] = null;
            total --;
            return true;
        }
        return false;
    }

    /**
     * 返回所有客户对象，注意长度
     * @return
     */
    public Customer01[] getAllCustomers(){
        Customer01[] custs = new Customer01[total];//新建数组来保存
        for (int i = 0; i < custs.length; i++) {
            custs[i] = customer01s[i];//只是复制过来的地址
        }
        return custs;
    }

    /**
     * 返回index的指定客户对象
     * @param index
     * @return
     */
    public Customer01 getCustomer(int index){
        if(index > 0 && index < total){
            return customer01s[index];
        }
        return null;
    }

    /**
     * 返回当前数组中的客户数量
     * @return
     */
    public int getTotal(){
        return total;
    }
}
