package com.ls.juc.socket;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        //1.获取  服务器IP
        Socket socket = null;
        OutputStream outputStream = null;
        Scanner scanner = null;
        try {

            InetAddress serIP = InetAddress.getByName("127.0.0.1");
            int port = 9999;

            //2. 创建连接
            socket = new Socket(serIP, port);
            //3.发送信息
            outputStream = socket.getOutputStream();
            scanner = new Scanner(System.in);

            String next = scanner.next();
            outputStream.write(next.getBytes());


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner != null) {
                scanner.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
