package com.my.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.my.Server;


public class MultiThreadedServerImpl implements MultiThreadedServer{

    private final ExecutorService executorService;

    private static final int port = 8081;
    public MultiThreadedServerImpl(){
        this.executorService = Executors.newFixedThreadPool(20);
    }

    @Override
    public void start(){
        try{

               try(ServerSocket socket = new ServerSocket(port)){
                   socket.setSoTimeout(10000);
                   while(true){
                       System.out.println("Server listening at port " + port);
                       Socket acceptedConnection = socket.accept();

                       System.out.println("connection accepted at "+ acceptedConnection.getRemoteSocketAddress());

                       executorService.submit(new ClientHandler(acceptedConnection));
                   }
               }catch (Exception e){
                   e.printStackTrace();
               }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
