package com.ls.juc.socket.talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
    DatagramSocket datagramSocket = null;
    BufferedReader reader = null;
    private int fromPort;
    private int toPort;
    private String toIp;

    public TalkSend(int fromPort, String toIp, int toPort) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.toIp = toIp;

        try {
            datagramSocket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        while (true) {
            try {
                String data = reader.readLine();
                byte[] bytes = data.getBytes();
                DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                        new InetSocketAddress(this.toIp, toPort));
                datagramSocket.send(datagramPacket);
                if (data.equals("bye")) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        datagramSocket.close();


    }
}
