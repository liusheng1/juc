package com.ls.juc.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClientDemo {
    public static void main(String[] args) throws Exception {
        //建立连接
        DatagramSocket datagramSocket = new DatagramSocket();
        //创建数据包
        //发送信息
        String msg = "刘大爷 你真厉害";
        //发给谁了
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        int port = 9090;
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, byName, port);
        //发送
        datagramSocket.send(datagramPacket);

    }
}
