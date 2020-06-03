package com.ls.juc.socket.talk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkRecever implements  Runnable{
    DatagramSocket datagramSocket = null;
    private int port;
    private  String msg;

    public TalkRecever(int port,String msg) {
        this.port = port;
        this.msg = msg;
        try {
           datagramSocket = new DatagramSocket(port);

        } catch (SocketException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        while (true){
            //接受数据包

            try {
                byte[] bytes = new byte[1024];
                DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length);
                datagramSocket.receive(datagramPacket);
                byte[] data = datagramPacket.getData();
                String recceiverdatas=new String(data,0,data.length);
                System.out.println(this.msg+":"+recceiverdatas);
                if (recceiverdatas.contains("bye")){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
        datagramSocket.close();

    }
}
