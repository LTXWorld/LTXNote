package com.lulu.test;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 描述
 *
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，
 * 然后根据指定的待入库的新图书的位置和信息，将新图书插入到图书表中指定的位置上，
 * 最后输出新图书入库后所有图书的信息。
 * 输入
 *
 * 总计n+3行。首先输入n+1行，其中，第一行是图书数目n，后n行是n本图书的信息（书号、书名、价格），
 * 每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。
 * 其中书号和书名为字符串类型，价格为浮点数类型。之后输入第n+2行，
 * 内容仅为一个整数，代表待入库的新图书的位置序号。最后输入第n+3行，内容为新图书的信息，书号、书名、价格用空格分隔。
 *
 * 输出
 *
 * 若插入成功： 输出新图书入库后所有图书的信息（书号、书名、价格），
 * 总计n+1行，每行是一本图书的信息，书号、书名、价格用空格分隔。其中价格输出保留两位小数。
 * 若插入失败： 只输出以下提示：抱歉，入库位置非法！
 */
public class MainGetIn {
    /**
     * 本题的思路，好处在于他没有插入很多，只需要插入一个位置
     * 但是顺序表的插入很麻烦，得让后面的元素移动，所以这道题我想要不先插入，再填充信息
     * 但是你得根据输入信息的顺序来啊，插入位置这个关键信息是后面才输入的，所以能这样做吗？
     * 至于插入是否成功看范围即可，注意他给出的插入位置从1开始，所以1-n是可以的
     * 并且插入这个操作你得扩容吧，所以难免再去新申请一个数组来存放插入后的内容
     *
     * 最终发现这个方法超时了。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BestBook[] books = new BestBook[n];
        //写入信息
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            books[i] = new BestBook(id,name,price);
        }
        int index = sc.nextInt();
        sc.nextLine();
        //后面还有信息你得先接收了
        String id = sc.next();
        String name = sc.next();
        double price = sc.nextDouble();
        //进行插入操作
        if (index > 0 && index <= n){
            //创建一个新的数组来保存新的内容
            BestBook[] books1 = new BestBook[n + 1];
            //先把新插入的信息插进来
            books1[index - 1] = new BestBook(id,name,price);
            //再填充其他信息时先填充index之前的，再填充之后的
            for (int i = 0; i < index - 1; i++) {
                books1[i] = books[i];
            }
            //
            for (int i = index; i < n + 1; i++) {
                books1[i] = books[i];
            }
            //最后再输出
            for (int i = 0; i < n + 1; i++) {
                System.out.println(books1[i]);
            }
        }else {
            //插入位置有误
            System.out.println("Sorry，the position to be inserted is invalid!");
        }


    }
}
class BookIn{
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookIn(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f",price);
    }
}
