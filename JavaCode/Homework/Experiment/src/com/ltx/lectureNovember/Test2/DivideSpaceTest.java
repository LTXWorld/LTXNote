package com.ltx.lectureNovember.Test2;

import java.io.*;

/**
 * @author 陆涛
 * @version 1.0
 */
public class DivideSpaceTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("E:\\GitT\\JavaCode\\Homework\\Experiment\\src\\com\\ltx\\lectureNovember\\Test2\\test1.txt");
            outputStream = new FileOutputStream("test22.txt");

            int data;//每次读出的是一个int类型数据
            StringBuilder word = new StringBuilder();
            while ((data = inputStream.read()) != -1){
                char ch = (char) data;

                if (ch ==' ' || ch == '\n'){
                    outputStream.write(word.toString().getBytes());
                    outputStream.write('\n');
                    word = new StringBuilder();
                }else {
                    word.append(ch);
                }
            }
            //
            if (word.length() > 0){
                outputStream.write(word.toString().getBytes());
                outputStream.write('\n');
            }
            System.out.println("已经全部接收");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (outputStream != null){
                outputStream.close();
            }
        }
    }
}
