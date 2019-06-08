/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Arrays;

/**
 *
 * @author brian
 */
public class ServerProtocol {
    //This class describes how your server reacts to the messages of your client
    int status = 0;
    String toycode, toyname, descrption;
    String [] questions = {"Toy Code", "Toy Name","Toy Description","Toy Price","Date of Manufacture","Batch Number","Company Name","Street Adress","Zip Code","Country","Message"};
    String [] answers = {"","","","","","","","","","",""};
    public String processInput(String theInput){
        String theOutput = "You typed this: \n";
         // The beginning of the program
        if (theInput == null){
           theOutput = questions[status];
           status = 1;
        }
        else if(theInput.isBlank()){
            theOutput = "Input cannot be empty. "+questions[status-1];
            answers[status-1] = theInput;
        }
        /*
        else if(theInput.equals("123")){
            theOutput = "Bye.";
        }
        */
        //continue asking questions and receiving answers    
        else if(status < questions.length){
            answers[status-1] = theInput;
            theOutput = questions[status];
            status = status+1; 
        //the last question
        } else if(status == questions.length){
            answers[status-1] = theInput;
            theOutput = Arrays.toString(finalOutput());
            status = status+1;
        //after the last answer from client    
        } else if (status == 12){
            if(theInput.contains("yes")){
                theOutput = "Successful Transaction. Bye.";
            }else{
                theOutput = "Failed Transaction. Bye.";
            }
        }
        return theOutput;
    }
    
    //display all the items sent by the client
    public String[] finalOutput(){
        return answers;
    }
    
}
