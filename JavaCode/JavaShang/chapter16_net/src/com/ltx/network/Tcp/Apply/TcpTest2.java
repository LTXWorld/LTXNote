package com.ltx.network.Tcp.Apply;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TcpTest2
 * Package:com.ltx.network.First.Apply
 * Description:客户端发送文件给服务器，服务器将文件保存在本地
 *Problem:服务器无法收到客户端发送的，无法完成复制文件
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/30 08:41
 */
public class TcpTest2 {
    @Test
    public void client() throws IOException {
        //1创建socket
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        Socket socket = new Socket(inetAddress,port);
        //2创建file实例，创建输入流，
        File file = new File("pic.png");
        FileInputStream fis = new FileInputStream(file);
        //3通过socket获得输出流
        OutputStream os = socket.getOutputStream();
        //4读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        System.out.println("数据发送完毕");
        //接受来自服务器端
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[5];
        int len2;
        while ((len2 = is.read(buffer2)) != - 1){
            byteArrayOutputStream.write(buffer2,0,len2);
        }
        socket.shutdownOutput();
        //5关闭相关流与资源
        os.close();
        fis.close();
        socket.close();
    }
    @Test
    public void server() throws IOException{
        //1socket
        int port = 9090;
        ServerSocket serverSocket = new ServerSocket(port);
        //2使用accept方法接受来自于客户端的socket
        Socket socket = serverSocket.accept();
        //3输入流
        InputStream inputStream = socket.getInputStream();

        //4file实例，output实例
        File file = new File("pic_copy.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //5读写数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer)) != - 1){
            fileOutputStream.write(buffer,0,len);
        }
        System.out.println("数据接受完毕");
        //6服务端发送数据给客户端
        OutputStream os = socket.getOutputStream();
        os.write("很漂亮" .getBytes());
        //7关闭
        os.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
