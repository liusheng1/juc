package com.ls.juc.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientDemo1 {
    public static void main(String[] args) throws Exception {
        //创建连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9998);
        //2.创建输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.读取文件
        FileInputStream fileInputStream = new FileInputStream(new File("gitlab.yml"));
        //4.写出文件
        byte bu[] = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(bu)) != -1) {
            outputStream.write(bu, 0, len);
        }
        //通知服务器 我已经传输完成
        socket.shutdownOutput();
        //确认服务器接受完成
        InputStream inputStream = socket.getInputStream();
        byte buff[] = new byte[1024];
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        int len1 = 0;
        while ((len1 = inputStream.read(buff)) != -1) {

            b.write(bu, 0, len1);
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (socket != null) {
            socket.close();
        }

    }
}
