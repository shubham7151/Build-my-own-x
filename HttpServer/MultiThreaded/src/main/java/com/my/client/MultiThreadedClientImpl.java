package com.my.client;

import com.my.Client;

public class MultiThreadedClientImpl implements MultiThreadedClient{


    private Client client;

    public MultiThreadedClientImpl(){
        this.client = new Client();
    }
    @Override
    public void hit(){
        try{
            client.run();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
