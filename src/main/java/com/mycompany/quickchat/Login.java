/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 * Login class for QuickChat - Part 1
 * Handles registration and login logic
 * @author Lorenza 
 */
public class Login {
    
    //Private fields to store registered user details (encapsulation) 
    private String storedUsername;
    private String storedPassword;
    private String storedCellNumber;
    private String storedFirstName;
    private String storedLastName;
    
    /**
    *Checks if the username contains an underscore (_) and is no more than 5 characters
    * 
    * @param username The username entered by the user
    * @return true if username is correctly formatted, false otherwise 
    */
     public boolean checkUserName(String username){
         return username != null && username.contains("_") && username.length() <=5;
     }
     /**
          * Check password complexity rules: 
          * - At least 8 characters 
          * - Contains a capital letter
          * - Contains a number 
          * - Contains a special character
          * 
          * @param password The password entered by the user 
          * @return true if the password meets all complexity rules, false otherwise 
          */
     public boolean checkPasswordComplexity(String password){
         if (password == null || password.length() < 8){
             return false;
         }
         
         boolean hasUpper = false;
         boolean hasDigit = false;
         boolean hasSpecial = false;
         
         for (char c : password.toCharArray()){
             if (Character.isUpperCase(c)) hasUpper = true;
             if (Character.isDigit(c)) hasDigit = true;
             if (!Character.isLetterOrDigit(c)) hasSpecial = true;
         }
         
         return hasUpper && hasDigit && hasSpecial;
     }
     
     /**
      * Validates South African international cell phone number.
      * Must start with +27 followed by exactly 9 digits
      * 
      * @param cell The cell phone number entered by the user 
      * @return true if the cell number is correctly formatted, false otherwise 
      */
     public boolean checkCellPhoneNumber(String cell) {
         String regex = "^\\+27\\d{9}$";
         return cell != null && cell.matches(regex);
     }
     
     /**
     * Registers the user only if all validations pass.
     * Stores username, password, cell number, first name and last name.
     *
     * @param username Username to register
     * @param password Password to register
     * @param cellNumber South African cell number
     * @param firstName User's first name
     * @param lastName User's last name
     * @return Success or error message
     */
     
     public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
        
        String message = ""; 
        //Username Validation 
         if (checkUserName(username)) {
             message += "Username successfully captured.\n";
         } else {
            message += "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.\n";
        }
         //Password validation 
        if (checkPasswordComplexity(password)) {
            message += "Password successfully captured.\n";
        } else {
            message +=  "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n";
        }
        //Cell number validation 
        if (checkCellPhoneNumber(cellNumber)) {
            message += "Cell phone number successfully captured.\n";
        } else {
            message += "Cell phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.\n";
        }
        
        //Final registration check 
        if (checkUserName(username)
                && checkPasswordComplexity(password)
                && checkCellPhoneNumber(cellNumber)){

        // Store all user details
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellNumber = cellNumber;
        this.storedFirstName = firstName;
        this.storedLastName = lastName;

        message += "The user has been registered successfully!";
    }
     return message;
     }
     /**
      * Verifies login credentials
      * 
      * @param username Entered username 
      * @param password Entered password
      * @return true if login is successful, false otherwise 
      */
     public boolean loginUser(String username, String password) {
        if (storedUsername == null || storedPassword == null) {
            return false;
        }
        return storedUsername.equals(username) && storedPassword.equals(password);
    }
     
     /**
      * Returns the login status message
      * 
      * @param loggedIn Result from loginUser() method 
      * @return Welcome message or error message 
      */
     public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + storedFirstName + " " + storedLastName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
     }
}
