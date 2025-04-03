package com.my.client;


import com.my.Client;

public class ClientMain {

    public static void main(String[] args){
        System.out.println("Client Running");
        MultiThreadedClient client = new MultiThreadedClientImpl();
        client.hit();
    }
}
