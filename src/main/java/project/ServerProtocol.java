/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author brian
 */
public class ServerProtocol {
    //This class describes how your server reacts to the messages of your client 
    public String processInput(String theInput){
        String theOutput = "yellow yellow";
        if (theInput.equals("123")){
            theOutput = "Bye.";
        }
        return theOutput;
    }
    
}
