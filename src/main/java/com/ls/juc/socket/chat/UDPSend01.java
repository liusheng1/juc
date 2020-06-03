package com.ls.juc.socket.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPSend01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        while (true){

            //接受数据包
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            String recceiverdatas=new String(data,0,data.length);
            System.out.println(recceiverdatas);
            if (recceiverdatas.contains("bye")){
               break;
            }

            //准备数据  从控制台获取
          //  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

        }
        datagramSocket.close();

    }
}
