package com.ltx.network.Tcp.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ClassName: InetAddress
 * Package:com.ltx.network.First.Test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/28 17:19
 */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress IpAd = InetAddress.getByName("192.168.23.31");
            System.out.println(IpAd);
            InetAddress IPAd2 = InetAddress.getByName("www.baidu.com");
            System.out.println(IPAd2);

//            InetAddress localHost = InetAddress.getLocalHost();
//            System.out.println(localHost);

            //
            System.out.println(IPAd2.getHostName());
            System.out.println(IPAd2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
