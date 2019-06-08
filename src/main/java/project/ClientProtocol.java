/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.Socket;
import java.sql.Timestamp;

/**
 *
 * @author brian
 */
public class ClientProtocol {
    //This class describes how your client reacts to your servers messages
    String UserResponse;
    public String processServerMessage(String fromServer, String userInput, Socket soc){
        //if server wants thank you message generate unique code
        if(fromServer.contains("Message")){
            UserResponse = userInput+" Unique code: "+soc.getLocalSocketAddress()+"/"+new Timestamp(System.currentTimeMillis());
        }else{
        //the conversation continues
            UserResponse = userInput;
        }
        return UserResponse;
    }
}
