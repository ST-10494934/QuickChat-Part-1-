/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Unit Test class for Login - Part 1 
 * Test all required methods using the test data 
 * 
 * @author Lorenza 
 */
public class LoginTest {
    
    private final Login login = new Login();
    
    // === Validation Method Test ===
    
    //Username test 
    @Test 
    public void testUsernameCorrectlyFormatted(){
        assertTrue(login.checkUserName("kyl_1"));
    }
    
    @Test 
    public void testUsernameIncorrectlyFormatted(){
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    @Test 
    public void testUsernameCorrectMessage(){
        String expected = "Username successfully captured.\n"
                + "Password successfully captured.\n"
                + "Cell phone number successfully captured.\n"
                + "The user has been registered successfully!";
        
        String actual = login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );
        assertEquals(expected,actual);        
    }
    // Password test 
    @Test 
    public void testPasswordMeetsComplexity(){
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test 
    public void testPasswordDoesNotMeetComplexity(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test 
    public void testPasswordCorrectMessage(){
        String expected = "Username successfully captured.\n"
                + "Password successfully captured.\n"
                + "Cell phone number successfully captured.\n"
                + "The user has been registered successfully!";
        String actual = login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        );
        assertEquals(expected,actual); 
    }
    
    @Test 
    public void testPasswordIncorrectMessage(){
        String actual = login.registerUser(
                "kyl_1",
                "password",
                "+27838968976",
                "Kyle",
                "Smith"
        );
        assertTrue(actual.contains(
                "Password is not correctly formatted"
        ));
    }
    //Cell phone test  
    @Test 
    public void testCellPhoneCorrectlyFormatted(){
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test 
    public void testCellPhoneIncorrectlyFormatted(){
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    @Test 
    public void testCellPhoneCorrectMessage(){
        String expected = "Username successfully captured.\n"
                + "Password successfully captured.\n"
                + "Cell phone number successfully captured.\n"
                + "The user has been registered successfully!";
        
        String actual = login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Kyle",
                "Smith"
        ); 
        assertEquals(expected, actual);
    }
    
    @Test 
    public void testCellPhoneIncorrectMessage(){
        String actual = login.registerUser(
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553",
                "Kyle",
                "Smith"
        ); 
        assertTrue(actual.contains(
                "Cell phone number is incorrectly formatted"
        ));
    }
    // === Login Tests ===
    
    @Test 
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("wronguser", "wrongpass"));
    }
    
    @Test
    public void testReturnLoginStatusSuccess(){
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        
        boolean loggedIn = login.loginUser("kyl_1", "Ch&&sec@ke99!");
        String expected = "Welcome Kyle Smith, it is great to see you again."; 
        assertEquals(expected, login.returnLoginStatus(loggedIn));
    }
    
    @Test 
    public void testReturnLoginStatusFailure(){
        String expected = "Username or password incorrect, please try again.";
        assertEquals(expected, login.returnLoginStatus(false));
    }
}
