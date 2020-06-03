package com.ls.juc.socket.talk;

public class TalkC {
    //开启两个线程
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"127.0.0.1",9999)).start();
        new Thread(new TalkRecever(8888,"Cgfgffg")).start();
    }
}
