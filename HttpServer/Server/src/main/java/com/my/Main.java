package com.my;


public class Main {
    public static void main(String[] args) {

        Server server = new Server();
        try{
            server.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
