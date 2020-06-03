package com.ls.juc.socket.talk;

public class TalkP {
    //开启两个线程
    public static void main(String[] args) {
        new Thread(new TalkSend(4444,"127.0.0.1",8888)).start();
        new Thread(new TalkRecever(9999,"pdsfdfdfg")).start();
    }
}
