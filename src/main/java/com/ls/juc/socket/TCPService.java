package com.ls.juc.socket;

import javax.lang.model.element.VariableElement;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        //固定的IP
        try {
            serverSocket = new ServerSocket(9999);
            //等待客户端连接
            while (true){
                socket = serverSocket.accept();


            //接受客户短信息
            inputStream = socket.getInputStream();
            //管道流
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte b[] = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(b)) != -1) {
                byteArrayOutputStream.write(b, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


        }
    }

}
