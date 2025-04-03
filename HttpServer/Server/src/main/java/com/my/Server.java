package com.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    private static  final int port = 8010;
    public void run(){
        try (ServerSocket socket = new ServerSocket(port)) {
            socket.setSoTimeout(10000);

            while(true){
                /*
                    Accept any request till timeout
                 */
                System.out.println("Server Listening on port "+port);
                Socket acceptedConnection = socket.accept();
                /*
                    Once accepted the request print the address of the client.
                 */
                System.out.println(("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress()));
                /*
                    output stream is when you are sending info to client So basically we are using printWriter class to
                    send some response to the client
                    convert the data into bytes and sent it over connection
                 */
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                /*
                    input stream is when you are listening info from client So basically we are using Buffer reader a type of Reader to
                    read from socket
                    read the data from the connection and prints it on system
                 */
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));

                /*
                    So here we are sending this response to the client using print writer object created.
                    the below line will be printed to client system.
                 */
                toClient.println("Hello from custom server : from build your own X");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            }
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
    }
}
