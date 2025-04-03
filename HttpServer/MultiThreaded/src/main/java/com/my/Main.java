package com.my;


import com.my.server.MultiThreadedServer;
import com.my.server.MultiThreadedServerImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server Running");
        MultiThreadedServer multiThreadedServer = new MultiThreadedServerImpl();
        multiThreadedServer.start();
    }
}