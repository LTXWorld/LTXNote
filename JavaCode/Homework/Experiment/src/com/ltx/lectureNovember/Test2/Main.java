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
            //输入流是要处理的文件，输出流是处理完后的所需文件
            inputStream = new FileInputStream("/Users/lutao/Documents/java/Homework/Experiment/src/com/ltx/lectureNovember/Test2/test1.txt");
            outputStream = new FileOutputStream("test2.txt");

            int data;
            StringBuilder word = new StringBuilder();//没遇到空格之前都先暂存在builder中
            while ((data = inputStream.read()) != -1){//只要不等于-1就证明输入流还有东西要读,每次读出一个字符
                char ch = (char) data;

                if (ch ==' ' || ch == '\n'){
                    outputStream.write(word.toString().getBytes());//写入输出流,注意最后要转化为比特
                    outputStream.write('\n');//记得换行
                    word = new StringBuilder();//每次清空builder（即新建一个）
                }else {
                    word.append(ch);
                }
            }
            //处理最后一个单词，因为他后面没空格了。
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
