package com.ls.juc.socket.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class UDPSend02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        //准备数据  从控制台获取
        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] bytes = data.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress("127.0.0.1",
                    6666));
            datagramSocket.send(datagramPacket);
            if (data.equals("bye")){
                break;
            }
        }
        datagramSocket.close();


    }
}
