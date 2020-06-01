package com.ls.juc.net;

import sun.net.util.IPAddressUtil;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        InetAddress localHost1 = Inet6Address.getLocalHost();
        System.out.println(localHost1);


    }
}
