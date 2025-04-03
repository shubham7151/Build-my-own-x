package com.my;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int port = 8010;

    public void run(){
        try {
            /*
                InetAddress represent ipaddress of the server.
             */
            InetAddress address = InetAddress.getByName("localhost");
            /*
                Create socket that is nothing but end point for connecting between two machine. it compose of an ip and port of that machine
             */
            Socket socket = new Socket(address,port);
            /*
                toSocket : it's the message sent to socket from the client
             */
            PrintWriter toSocket =  new PrintWriter(socket.getOutputStream());
            BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toSocket.println("Hello from Client");
            String response = fromSocket.readLine();
            System.out.println("Response from socket is "+ response);
            toSocket.close();
            fromSocket.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
