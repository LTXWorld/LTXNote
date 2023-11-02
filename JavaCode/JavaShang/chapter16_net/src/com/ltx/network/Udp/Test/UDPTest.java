package com.ltx.network.Udp.Test;

import org.junit.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * ClassName: UDPTest
 * Package:com.ltx.network.Udp.Test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/30 09:27
 */
public class UDPTest {
    @Test
    public void sender() throws Exception{
        DatagramSocket ds = new DatagramSocket();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        byte[] bytes = "我是发送端".getBytes("utf-8");
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,inetAddress,port);

        ds.send(packet);

        ds.close();
    }

    @Test
    public void receiver() throws Exception{
        //创建Socket实例，注意构造器需要接受端口号
        int port = 9090;
        DatagramSocket ds = new DatagramSocket(port);
        //创建数据报对象，用于接受发送的数据
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        //接受数据
        ds.receive(packet);
        //获取数据
        String s = new String(packet.getData(),0,packet.getLength());
        System.out.println(s);

        ds.close();
    }
}
