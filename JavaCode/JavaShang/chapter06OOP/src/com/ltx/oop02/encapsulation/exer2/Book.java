package com.ltx.oop02.encapsulation.exer2;

/**
 * ClassName: Book
 * Package:com.ltx.oop02.encapsulation.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/30 16:04
 */
public class Book {
    private String bookName;
    private String author;
    private double price;

    public String getBookName(){
        return bookName;
    }
    public void setBookName(String bn){
        bookName = bn;
    }
}
