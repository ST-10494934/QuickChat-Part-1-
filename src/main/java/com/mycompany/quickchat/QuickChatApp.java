/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *Main console application for QuickChatApp - Part 1 
 * This is the entry point of the program
 * 
 * @author Lorenza 
 */
public class QuickChatApp {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        
         //Banner
    printBanner(" === QUICKCHAT - REGISTRATION & LOGIN === ");
    
    System.out.println("=== CREATE YOUR ACCOUNT ===\n");
    
    System.out.print("Enter first name: ");
    String firstName = scanner.nextLine().trim();
    
    System.out.print("Enter last name: ");
    String lastName = scanner.nextLine().trim();
    
    System.out.print("Enter username (e.g., kyl_1): ");
    String username = scanner.nextLine().trim();
    
    System.out.print("Enter password: ");
    String password = scanner.nextLine().trim();
    
    System.out.print("Enter cell number (e.g., +27350264895): ");
    String cell = scanner.nextLine().trim();
    
    String registerMessage = login.registerUser(username, password, cell, firstName, lastName);
    System.out.println("\n" + registerMessage);
    
    //Stop if registration failed 
    if (!registerMessage.contains("registered successfully")){
        System.out.println("Registration failed. Please restart and try again");
        scanner.close();
        return;
    }
    
    //Login
    System.out.println("\n === LOGIN TO YOUR ACCOUNT ===");
    System.out.print("Enter username: ");
    String loginUser = scanner.nextLine().trim();
    
    System.out.print("Enter passowrd: ");
    String loginPass = scanner.nextLine().trim(); 
    
    boolean isLoggedIn = login.loginUser(loginUser, loginPass);
    System.out.println("\n" + login.returnLoginStatus(isLoggedIn));
    
    // Stop if login failed 
    if (!isLoggedIn) {
    System.out.println("Login failed. Please restart and try again.");
    scanner.close();
    return;
    }
    
    //Welcome abd message limit 
    System.out.println("\nWelcome to QuickChat.");
    System.out.print("\nHow many messages would you like to send this session? ");
    int maxMessages = Integer.parseInt(scanner.nextLine().trim());
    
    int totalSent = 0;
    boolean running = true;
    
    //Main menu loop 
    while (running){
        printMenu();
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine().trim(); 
        
        switch (choice){
            
            case "1": 
                //For loop runs exactly the number of times the user specified 
                for (int i = 0; i < maxMessages; i++) {
                    int messageNumber = i + 1;
                    System.out.println("\n--- Message " + messageNumber
                    + "of" + maxMessages + " ---");
                    
                    // Recipient validation loop
                    String recipient;
                    Message tempCheck = new Message(messageNumber, "+27000000000", "temp");
                    while (true){
                        System.out.print("Enter recipient cell number (e.g., +27838968976): ");
                        recipient = scanner.nextLine().trim();
                        if (tempCheck.checkRecipientCell(recipient)
                                .contains("successfully")){
                            System.out.println("Cell phone number successfully captured.");
                            break;
                        }
                        System.out.println(tempCheck.checkRecipientCell(recipient));
                    }
                    // Message text validation loop
                    String messageText;
                    while (true){
                        System.out.print("Enter your message (max 250 characters): ");
                        messageText = scanner.nextLine().trim();
                        if (messageText.length() <= 250){
                            System.out.println("Message ready to send.");
                            break;
                        } else {
                            int over = messageText.length() - 250; 
                            System.out.println("Message exceeds 250 characters by "
                                    + over + "; please reduce the size.");
                        }
                    }
                    // Create the message object 
                    Message message = new Message(messageNumber, recipient, messageText);
                    System.out.println("Message Hash: " + message.getMessageHash());
                    
                    //Let user choose what to do with the message
                    String status = message.sentMessage();
                    System.out.println(status);
                    
                    //Only show full details and count if actually sent 
                    if (status.equals("Message successfully sent.")){
                        totalSent++;
                        System.out.println("\n--- Message Details --- ");
                        System.out.println(message.printMessages());
                    }
                }
                System.out.println("\nTotal messsages sent: " + totalSent);
                break;
            
            case "2":
                System.out.println("Coming Soon. ");
                break;
                
            case "3":
                System.out.println("Thank you for using QuickChat. Goodbye!");
                running = false; 
                break;
              
            default: 
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
        }
    }
    scanner.close();
    } 
    
    private static void printMenu(){
        System.out.println("\n=== QUICKCHAT MENU ===");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
    }
 
    private static void printBanner(String title){
    
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                  " + title + "            ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        }  
    }
    
    
    
    
    

