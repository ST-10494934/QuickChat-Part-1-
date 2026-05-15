/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Message class for QuickChat - Part 2 
 * Handles message creation, validation, hashing, sending and storing 
 * JSON storage uses the GSON library by Google: https://github.com/google/gson 
 * @author Lorennza
 */
public class Message {
    
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    
    //File name for storing messages as JSON 
    private static final String JSON_FILE = "stored_message.json";
    
    /**
     * Constructor 
     * @param messageNumber the number in the session 
     * @param recipient the recipient cell number 
     * @param messageText the message content 
     */
    public Message(int messageNumber, String recipient,String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }
    /** 
     * Generate a random 10-digit ID as a string 
     * 
     * @return 10-digit ID as a string 
     */
    private String generateMessageID(){
        Random random = new Random();
        long id = (long) (random.nextDouble()*9_000_000_000L)+1_000_000_000L;
        return String.valueOf(id);
    }
    
    /**
     * Checks that the message ID is not more than 10 characters 
     * 
     * @return true if valid, false otherwise
     */
    public boolean checkMessageID(){
        return messageID !=null && messageID.length() <= 10;
    }
    
    /**
     * Checks recipient cell number is correctly formatted with international code 
     * 
     * @param cell the recipient cell number 
     * @return success of failure message 
     */
    public String checkRecipientCell(String cell){
        if (cell != null && cell.matches("^\\+27\\d{9}$")){
            return "Cell phone number successfully captured.";
        }
        return "Cell phone number is incorrectly formatted or does not contain"
                + "an international code. Please correct the number and try again.";
    }
    
    /**
     * Creates and returns the message hash 
     * Format: first 2 digits of ID: message number: first word + last word (all caps) 
     * 
     * @return the message hash string 
     */
    public String createMessageHash(){
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        //Remove punctuation from last word 
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");
        return (firstTwo + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }
    
    /**
     * Allows user to send, disregard or store the message 
     * 
     * @return status message based on user choice 
     */
    public String sentMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message");
        System.out.println("Choose an option ");
        
        String choice = scanner.nextLine().trim();
        
        switch (choice){
            case "1":
                return "Message successfully sent.";
            case "2":
                return "Press 0 to delete the message.";
            case "3":
                storeMessage();
                return "Message successfully stored.";
            default:
                return "Invalid option selected.";
        }
    }
    /**
     * Returns the full details of this message as a formatted string 
     * 
     * @return formatted message details 
     */
    public String printMessages(){
        return "Message ID: " + messageID + "\n"
                + "Message Hash: " + messageHash + "\n"
                + "Recipient: " + recipient + "\n"
                + "Message: " + messageText;           
    }
/**
 * Returns the total number of messages sent 
 * 
 * @param sentCount running count of sent messages 
 * @return total sent 
 */
public int returnTotalMessages(int sentCount){
    return sentCount;
}
/**
 * Stores the message in a JSON file using Gson 
 * Reference: Gson library by Google - https://github.com/google/gson
 */
public void storeMessage(){
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<MessageData> messages = new ArrayList<>();
    
    // Read any existing messages from the file first 
    try (FileReader reader = new FileReader(JSON_FILE)){
        Type listType = new TypeToken<List<MessageData>>(){}.getType();
        List<MessageData> existing = gson.fromJson(reader, listType);
        if (existing !=null){
            messages.addAll(existing);
        }
    } catch (IOException e){
         
    }
    
    //Add this message to the list 
    messages.add(new MessageData(messageID, messageNumber,
             recipient, messageText, messageHash));
    
    //Write the updated list back to the file
    try (FileWriter writer = new FileWriter(JSON_FILE)){
        gson.toJson(messages, writer);
    } catch (IOException e){
        System.out.println("Error storing message: " + e.getMessage());
    }
}

//Getters 
public String getMessageID() {return messageID;}
public int getMessageNumber() {return messageNumber;}
public String getRecipient() {return recipient;}
public String getMessageText() {return messageText;}
public String getMessageHash() {return messageHash;}

/**
 * Inner class used to structure data for JSON storage
 */
public static class MessageData {
    String messageID;
    int messageNumber;
    String recipient;
    String messageText;
    String messageHash;
    
    public MessageData(String messageID, int messageNumber, String recipient,
            String messageText, String messageHash) {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = messageHash;
    }
}
}
