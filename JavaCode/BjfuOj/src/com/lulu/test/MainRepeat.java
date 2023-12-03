package com.lulu.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 出版社出版的任何一本图书的书号（ISBN）都是唯一的，即图书表中不允许包含书号重复的图书。
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建
 * （书号可能重复），然后进行图书的去重，即删除书号重复的图书（只保留第一本），
 * 最后输出去重后所有图书的信息。
 *
 * 这道题思路先接收信息，再去里面根据id去找重复的书籍，找到第二个第三个重复时将其删除
 * 我想把找到重复书籍和删除它放在一个方法体内，遍历时直接调用这个方法
 */
public class MainRepeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        //
        ArrayList<BookRep> bookReps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = sc.nextLine().split(" ");
            String id = info[0];
            String name = info[1];
            double price = Double.parseDouble(info[2]);
            BookRep bookRep = new BookRep(id, name, price);
            bookReps.add(bookRep);
        }

        //寻找重复书号
        ArrayList<BookRep> uniqueBooks = RemoveRepeat(bookReps);//这个数组用来接收新数组
        //输出去重后的图书数量以及信息
        System.out.println(uniqueBooks.size());
        for(BookRep bookRep : uniqueBooks){
            System.out.println(bookRep.getId()+ " " + bookRep.getName() + " " + String.format("%.2f",bookRep.getPrice()) );
        }
    }

    //写一个方法进行去重
    public static ArrayList<BookRep> RemoveRepeat(ArrayList<BookRep> bookReps){
        ArrayList<BookRep> bookResult = new ArrayList<>();//创建一个新数组来保存最终去重后的结果
        for (BookRep bookRep : bookReps){
            if(! ContainRepeat(bookResult,bookRep.getId())){
                //注意这句话意思是在新创建的数组里面去重，这样会导致刚开始所有不一样的进来，当有一样的进来时if内为false
                bookResult.add(bookRep);//当书号不一样时，我们才把原来数组里面的元素加入到新数组当中
            }//书号一样就不操作，不把书籍加入新数组就行
        }
        return bookResult;
    }

    //写一个方法判断新数组里面是否存在你想要找的这个id，如果存在返回true不存在返回false
    //其实每次调用contain这个方法都是从头到尾在bookReps这个数组里面遍历了一次。
    public static boolean ContainRepeat(ArrayList<BookRep> bookReps,String id){
        for(BookRep bookRep : bookReps){
            if(bookRep.getId().equals(id)) {
                return true;
            }
        }
        return false;//找了一圈都不存在等于这个书号的，就返回false
    }
}
class BookRep{
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public BookRep(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
