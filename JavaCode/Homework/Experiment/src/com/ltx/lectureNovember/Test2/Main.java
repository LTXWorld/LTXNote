package com.ltx.lectureNovember.Test2;

import java.io.*;

/**
 * ClassName: Main
 * Package:com.ltx.lectureNovember.Test2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/31 15:29
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("/Users/lutao/Documents/java/Homework/Experiment/src/com/ltx/lectureNovember/Test2/test1.txt");
            outputStream = new FileOutputStream("test2.txt");

            int data;
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
            if (word.length() > 0){
                outputStream.write(word.toString().getBytes());
                outputStream.write('\n');
            }

            System.out.println("已全部成功写入");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null){
                    inputStream.close();
                }
                if (outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
