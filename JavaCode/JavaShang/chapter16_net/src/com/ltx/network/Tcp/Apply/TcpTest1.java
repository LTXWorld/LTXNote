package com.ltx.network.Tcp.Apply;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TcpTest1
 * Package:com.ltx.network.First.Apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/28 17:55
 */
public class TcpTest1 {
    @Test
    public void client() throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //创建socket,IP和端口是服务端的
            InetAddress DuiIP = InetAddress.getByName("192.168.12.107");
            int port = 8989;
            socket = new Socket(DuiIP,port);
            //发送数据
            outputStream = socket.getOutputStream();
            outputStream.write("你好我是客户端".getBytes());//输出字节流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭socket
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void server() throws IOException{
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        try {
            //创建socket
            int port = 8989;//自己的端口号
            serverSocket = new ServerSocket(port);
            //调用accept方法接受对面的socket
            accept = serverSocket.accept();
            System.out.println("服务器已开启");
            System.out.println("收到了来自于" + accept.getInetAddress().getHostAddress() + "的连接");
            //接受数据
            is = accept.getInputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1){
                String str = new String(buffer, 0, len);
                System.out.println(str);
            }
            System.out.println("数据接收完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭资源
            try {
                if (is != null) {
                    is.close();
                }
                if (accept != null) {
                    accept.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
