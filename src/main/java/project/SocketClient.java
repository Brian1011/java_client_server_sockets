/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.Socket;

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
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
