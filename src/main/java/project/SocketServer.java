/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

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
            //create a server socket
            ServerSocket ss = new ServerSocket(9806);
            Socket sos = ss.accept();
            System.out.println("Connection EStablished");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
