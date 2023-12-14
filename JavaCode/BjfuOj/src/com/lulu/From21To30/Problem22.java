package com.lulu.From21To30;

import java.util.*;

/**
 * @author 陆涛
 * @version 1.0
 * Ivan想先以解决的题目数量排序，如果解题数相同再以正确率排序，（如果解题数和正确率都相同那就按照默认的输入顺序）
 * 输入首先是一个正整数T（T<100），表示T组测试实例。
 * 第二行包含一个正整数m，表示有m（m<100）个账号需要进行排名，接下来是m行，
 * 每行包括一个字符串型的用户名u（长度不超过10），一个int型的解题数n，一个两位小数的正确率v。
 * 输出一个实时排名。将这些用户按照这样的规定进行排序：先按解题数排序，多的在前；
 * 再按照正确率排序，正确率高的在前；如果解题数和正确率都相同那就按照默认的输入顺序。
 * 每个用户占一行，包括一个用户名，一个解题数，一个正确率，（正确率的输出保留两位小数），以空格隔开，正确率之后没有空格。
 */
public class Problem22 {
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//T组测试实例
        while (T -- > 0){
            List<User> users = new ArrayList<>();
            int m = sc.nextInt();
            while (m -- > 0){
                //对这m个账号进行信息的接收,放入一个列表当中
                String name = sc.next();
                int num = sc.nextInt();
                double rate = sc.nextDouble();
                User user = new User(name, num, rate);
                users.add(user);
            }
            Sort(users);
            //输出结果
            for(User user : users){
                System.out.printf("%s %d %.2f\n", user.getName(),user.getNum(),user.getRate());
            }
        }
    }

    /**
     * 对每一组用户列表进行排序
     * @param list
     */
    private static void Sort(List<User> list){
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                if (u1.getNum() != u2.getNum()){
                    return u2.getNum() - u1.getNum();//降序？
                }else if (u1.getRate() != u2.getRate()){
                    return Double.compare(u2.getRate(), u1.getRate());
                }
                return 0;//都相同
            }
        });
    }
}
class User{
    private String name;
    private int num;//解题数
    private double rate;//正确率

    public User() {
    }

    public User(String name, int num, double rate) {
        this.name = name;
        this.num = num;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
