package com.my.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;



    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){

            try {

                System.out.println("===>" + Thread.currentThread().getName()+ "<===");

            /*
                toSocket : it's the message sent to socket from the client
             */
                PrintWriter toSocket =  new PrintWriter(socket.getOutputStream(),true);
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                toSocket.println("Hello from Client");
                String response = fromSocket.readLine();
                System.out.println("Response from socket is "+ response);

                System.out.println("===> After completing of task" + Thread.currentThread().getName()+ "<===");
                toSocket.close();
                fromSocket.close();
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }

    }
}
