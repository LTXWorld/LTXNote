package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 去重不一定要写成一个独立的方法，我们把它放在建立链表的过程中，每次尾插过程中去判断是否有书号相同的
 * 如果书号相同了就不去插入了。
 */
public class MainLian09Repeat02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        BookList92 bookList = new BookList92();
        for (int i = 0; i < n; i++) {
            String[] bookInfo = sc.nextLine().split(" ");
            String isbn = bookInfo[0];
            String name = bookInfo[1];
            double price = Double.parseDouble(bookInfo[2]);
            Book92 book92 = new Book92(isbn, name, price);
            bookList.addBookRepeat(book92);
        }
        System.out.println(bookList.getSize());
        bookList.printInfo();
    }

    static class Book92 {
        private String isbn;
        private String name;
        private double price;

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
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

        public Book92(String isbn, String name, double price) {
            this.isbn = isbn;
            this.name = name;
            this.price = price;
        }
    }

    static class BookNode {
        private Book92 book;
        private BookNode next;

        public BookNode(Book92 book) {
            this.book = book;
            this.next = null;
        }

        public BookNode getNext() {
            return next;
        }

        public void setNext(BookNode next) {
            this.next = next;
        }

        public Book92 getBook() {
            return book;
        }
    }

    static class BookList92 {
        private BookNode head;
        private int size;

        public BookList92() {
            this.head = null;
            this.size = 0;
        }

        public void addBookRepeat(Book92 book92) {
            if (head == null) {
                head = new BookNode(book92);
            } else {
                BookNode cur = head;
                while (cur.getNext() != null) {
                    //填充之前先看里面有没有书号相同的
                    if (cur.getBook().getIsbn().equals(book92.getIsbn())) {
                        return;
                    }
                    cur = cur.getNext();
                }
                //这里由于上面的while循环cur刚走到最后一个节点时，就会退出while循环，没有去判断，所以在下面加一个判断
                if (cur.getBook().getIsbn().equals(book92.getIsbn())) {
                    return;
                }
                cur.setNext(new BookNode(book92));//上述情况都不满足再插入。
            }
            size++;
        }

        public int getSize() {
            return size;
        }

        public void printInfo() {
            BookNode p = head.getNext();
            while (p != null) {
                Book92 book = p.getBook();
                System.out.printf("%s %s %.2f\n", book.getIsbn(), book.getName(), book.getPrice());
                p = p.getNext();
            }
        }
    }
}
