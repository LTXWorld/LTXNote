package com.lulu.test;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，
 * 然后根据指定的最爱图书的名字，查找最爱的图书，输出相应图书的信息。
 * 总计n+m+2行。首先输入n+1行，其中，第一行是图书数目n，后n行是n本图书的信息（书号、书名、价格），
 * 每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。
 * 其中书号和书名为字符串类型，价格为浮点数类型。然后输入m+1行，
 * 其中，第一行是一个整数m，代表查找m次，后m行是每次待查找的最爱图书名字。
 * 若查找成功： 总计输出m*（k+1）行，对于每一次查找，第一行是最爱图书数目（同一书名的图书可能有多本），
 * 后k行是最爱图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，
 * 其中价格输出保留两位小数。 若查找失败： 只输出以下提示：抱歉，没有你的最爱！
 */
public class MainChooseLike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BookD[] bookList = new BookD[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            bookList[i] = new BookD(id, name, price);
        }
        //继续后面的m+1行
        int m = sc.nextInt();
        sc.nextLine();//抵消掉换行符,这一步很重要。
        for (int i = 0; i < m; i++) {
            String name = sc.nextLine();
            BookD[] favorite = getFavorite(bookList,name);
            //这里的逻辑也十分巧妙！！
            if(favorite.length > 0){
                System.out.println(favorite.length);
                for(BookD bookD : favorite){
                    System.out.println(bookD);
                }
            }else {
                System.out.println("抱歉，没有你的最爱！");
            }
        }
//第一种方法大概可以像下面这样去做，但是最好还是将寻找最喜欢的书写成一个方法来运用。
//        //把后面要查找的东西能不能放入到一个新的数组当中
//        BookD[] likeList = new BookD[m];
//        for (int i = 0; i < m; i++) {
//            String id = sc.next();
//            String name = sc.next();
//            double price = sc.nextDouble();
//            likeList[i] = new BookD(id,name,price);

        //查找采用循环去找name相同的书籍
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(likeList[i].getName().equals(bookList[j].getName())){
//                    System.out.println(bookList[j]);//找到要找的了输出
//                }
//            }
//            //一圈下来在初始图书信息里都没有找到，即输出提示
//            System.out.println("抱歉，没有你的最爱！");
//        }
    }
    public static BookD[] getFavorite(BookD[] booklist,String name){
        //这个方法重点在于找到最喜欢并将最喜欢的书放在一个新的数组当中
        int count = 0;
        for (BookD bookD1 : booklist) {
            if (bookD1.getName().equals(name)){
                count ++;
            }
        }
        BookD[] favoriteBooks = new BookD[count];
        int i = 0;
        for (BookD b : booklist) {
            if (b.getName().equals(name)){
                favoriteBooks[i ++] = b;
            }
        }
        return favoriteBooks;
    }
}

class BookD{
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

    public BookD(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                id + " " + name + " " + String.format("%.2f",price) ;
    }
}
