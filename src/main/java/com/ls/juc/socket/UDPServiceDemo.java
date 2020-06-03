package com.ls.juc.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServiceDemo {
    public static void main(String[] args) throws Exception {
        //开放端口
        DatagramSocket datagramSocket = new DatagramSocket(9090);


        //接受数据包
        byte[] bytes = new byte[1024];

        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);
        System.out.println(datagramPacket.getAddress());
        System.out.println(datagramPacket.getData().toString());
        datagramSocket.close();

    }
}
