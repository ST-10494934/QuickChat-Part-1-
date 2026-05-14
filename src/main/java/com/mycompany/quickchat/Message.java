/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
        this.messageID = generatemessageID();
        this.messageHash = createMessageHash();
    }
}
