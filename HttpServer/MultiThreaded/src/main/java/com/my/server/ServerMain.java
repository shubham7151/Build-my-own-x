package com.my.server;

public class ServerMain {

    public static void main(String[] args){
        System.out.println("Server Running");
        MultiThreadedServer multiThreadedServer = new MultiThreadedServerImpl();
        multiThreadedServer.start();
    }
}
