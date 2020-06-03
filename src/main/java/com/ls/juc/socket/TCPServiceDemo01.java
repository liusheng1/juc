package com.ls.juc.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServiceDemo01 {
    public static void main(String[] args) throws IOException {
        //建立连接

        ServerSocket serverSocket = new ServerSocket(9998);
        //等待客户端接入
        Socket accept = serverSocket.accept();
        //获取客户端输入流
        InputStream inputStream = accept.getInputStream();
        //文件输出
        FileOutputStream liudaye = new FileOutputStream(new File("liudaye"));
         byte[] buff = new byte[1024];
         int len=0;

        while ((len=inputStream.read(buff))!=-1){
            liudaye.write(buff,0,len);
        }

        //确认接受完成
        accept.getOutputStream().write("我接受完了".getBytes());
        liudaye.close();
        inputStream.close();
        accept.close();
        serverSocket.close();


    }
}
