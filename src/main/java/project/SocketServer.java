/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author brian
 */
public class SocketServer {
    /*
    This class  sets up a  socket listening  for your client to 
    connect  -  and communicates with your client
    */
    public static void main(String[]args){
        try{
            //create a server socket and wait for a connection
            ServerSocket ss = new ServerSocket(9806);
            //Wait for connection and create a socket object
            Socket clientSocket = ss.accept();
            
            //send and recieve from client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Connection EStablished");
            
            String inputLine, outputLine;
            
            //Initiate conversation with client
            ServerProtocol sprotocol = new ServerProtocol();
            outputLine = sprotocol.processInput(null);
            out.println(outputLine);
            
            //Do a while loop to keep the conversation going
            while((inputLine = in.readLine()) != null){
                outputLine = sprotocol.processInput(inputLine);
                out.println(outputLine);
                if(outputLine.equals("Bye."))
                    break;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
