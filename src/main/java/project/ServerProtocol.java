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
    int status = 0;
    String toycode, toyname, descrption;
    public String processInput(String theInput){
        String theOutput = "yellow yellow";
        if (theInput == null){
           // The beginning of the program
           theOutput = "Enter Toy Code";
           status = 1;
        }
        else if(theInput.isBlank()){
            theOutput = "Input cannot be empty";
        }
        else if(theInput.equals("123")){
            theOutput = "Bye.";
        }
        // the conversation begins
        else if(status == 1){
            toycode = theInput;
            theOutput = "Enter Toyname";
            status = status+1;
        }else if(status == 2){
            toyname = theInput;
            theOutput="Done";
            status = status + 1;
        } else if(status == 3){
            //the program is done
            finalOutput();
            //theOutput = "Toy Code: "+toycode+"\n Toy Name: "+toyname;
        }
        
        return theOutput;
    }
    
    //display all the items sent by the client
    public String finalOutput(){
        String report = "Toy Code: "+toycode+"\n Toy Name: "+toyname;
        return report;
    }
    
}
