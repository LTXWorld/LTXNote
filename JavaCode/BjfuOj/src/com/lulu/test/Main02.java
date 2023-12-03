package com.lulu.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据完成图书信息表的创建，然后将图书按照价格降序排序
 逐行输出排序后每本图书的信息。

 输入

 输入n+1行，前n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。
 最后第n+1行是输入结束标志：0 0 0（空格分隔的三个0）。其中书号和书名为字符串类型，价格为浮点数类型。

 输出

 总计n行，每行是一本图书的信息（书号、书名、价格），书号、书名、价格用空格分隔。其中价格输出保留两位小数。 */
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //创建books数组保存各个books对象
        Book[] books = new Book[100];
        //统计目前读入的书的数量并且用来操作数组
        int n = 0;
        //进行数据的写入
        while (true){
            //写入书号，书名，价格
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            //根据输入输出信息进行equals判断
            if(id.equals("0") && name.equals("0") && price == 0){
                break;//停止进行数据的写入，即进行到了题目要求的最后一行
            }
            //最后对books数组进行填充
            books[n ++] = new Book(id,name,price);
        }
        //按照价格降序进行输出,这个sort的使用十分重要
        Arrays.sort(books, 0, n, new Comparator<Book>() {
            @Override//这里进行了传入匿名内部类的操作，并且重写的compare方法使用到了Double的compare
            public int compare(Book o1, Book o2) {
                return Double.compare(o2.getBookPrice(),o1.getBookPrice());
            }
        });
        for (int i = 0; i < n ; i++) {
            //注意输出的时候使用的是printf，因为后面进行了格式的控制，如果采用println则会报错
            System.out.printf("%s %s %2.f\n",books[i].getBookId(),books[i].getBookName(),books[i].getBookPrice());
        }
    }
}
class Book{
    private String BookId;
    private String BookName;
    private double BookPrice;

    public Book(String bookId, String bookName, double bookPrice) {
        BookId = bookId;
        BookName = bookName;
        BookPrice = bookPrice;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public double getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(double bookPrice) {
        BookPrice = bookPrice;
    }
}
