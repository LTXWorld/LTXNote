package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据完成图书信息表的创建，
 * 然后计算所有图书的平均价格，将所有低于平均价格的图书价格提高20%，
 * 所有高于或等于平均价格的图书价格提高10%，最后逐行输出价格修改后的图书信息。
 *
 * 这个代码的写法我们将指针放在图书类当中，在创建链表这玩意时，不需要申请链表类。
 * 直接设置头尾指针进行尾插法，其实这么看下来要比初始方法简单很多。
 */
public class MainLian03Change {
    //这个就正常接收然后计算总价，平均价格。再用增强for循环来修改图书信息即可
    //使用for each循环是否需要指针向后走，还是直接get价格就行
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //声明以下两个属性为了计算平均价格
        double sum = 0.0;
        int nums = 0;

        BookNode03 head = null;
        BookNode03 trail = null;//头尾指针用来插入

        while (true){
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            if(id.equals("0") && name.equals("0") && price == 0.0){
                break;
            }
            BookNode03 bookNode03 = new BookNode03(id, name, price);
            sum += price;
            nums ++;
            //进行链表的插入构建
            if(head == null){//为空新建
                head = bookNode03;
                trail = bookNode03;
            }else{//不为空尾插，设置尾指针为了更好地插入
                trail.next = bookNode03;
                trail = bookNode03;
            }
        }
        //计算平均价格
        double average = sum / nums;
        System.out.printf("%.2f\n",average);
        //进行调整价格
        BookNode03 cur = head;
        while (cur != null){
            if(cur.price >= average){
                cur.price *= 1.1;
            }else {
                cur.price *= 1.2;
            }
            System.out.printf("%s %s %.2f\n",cur.id,cur.name,cur.price);
            cur = cur.next;
        }
    }
}
class BookNode03{
    public String id;
    public String name;
    public double price;
    public BookNode03 next;

    public BookNode03(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}
