/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Timestamp;

/**
 *
 * @author brian
 */
public class SocketClient {
    /*
    This class connects to the server and communicates 
    with it according to the Client Protocol 
    */
    public static void main(String[]args){
        try {
            System.out.println("Client started");
            Socket soc = new Socket("localhost",9806);
            //Read from server
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            //Send to server with auto flash
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            //Client protocol
            ClientProtocol cProtocol = new ClientProtocol();
           
            //Read from keyboard
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String fromServer, fromUser;
            
            while((fromServer = in.readLine()) != null){
                System.out.println("Server: "+fromServer);
                //stop program
                if(fromServer.contains("Bye."))
                    break;
                //continue with conversation
                fromUser = stdIn.readLine();
                String UserResponse = cProtocol.processServerMessage(fromServer, fromUser, soc);
                if(fromUser!=null){
                    System.out.println("Client: "+UserResponse);
                    out.println(UserResponse);
                }
            }
            System.out.println("Client ID: "+soc.getLocalSocketAddress()+"/"+new Timestamp(System.currentTimeMillis()));
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

/*
if(fromServer.equals("Bye."))
    break;     
if(fromServer.contains("Message")){
    fromUser = stdIn.readLine()+"Unique code"+soc.getLocalSocketAddress()+"/"+new Timestamp(System.currentTimeMillis());
}else{
    fromUser = stdIn.readLine();
}
if(fromUser!=null){
        //fromUser = stdIn.readLine()+"Unique code"+soc.getLocalSocketAddress()+"/"+new Timestamp(System.currentTimeMillis());
    System.out.println("Client: "+fromUser);
    out.println(fromUser);
}*/