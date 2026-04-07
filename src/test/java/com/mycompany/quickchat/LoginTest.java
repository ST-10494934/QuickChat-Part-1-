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
    
    @Test 
    public void testUsernameCorrectlyFormatted(){
        assertTrue(login.checkUserName("kyl_1"));
    }
    
    @Test 
    public void testUsernameIncorrectlyFormatted(){
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    @Test 
    public void testPasswordMeetsComplexity(){
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    
    @Test 
    public void testPasswordDoesNotMeetComplexity(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test 
    public void testCellPhoneCorrectlyFormatted(){
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test 
    public void testCellPhoneIncorrectlyFormatted(){
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    // === Login Tests ===
    
    @Test 
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }
    
    @Test
    public void testLoginFailed() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("wronguser", "wrongpass"));
    }
    
    // === Boolean Check Test === 
    
    @Test 
    public void testUsernameCorrectlyFormattedBoolean(){
        assertTrue(login.checkUserName("kyl_1"));
    }
    
    @Test
    public void testUsernameIncorrectlyFormattedBoolean(){
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
    
    @Test
    public void testPasswordMeetsComplexityBoolean(){
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test 
    public void testPasswordDoesNotMeetComplexityBoolean(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testCellPhoneCorrectlyFormattedBoolean(){
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testCellPhoneIncorrectlyFormattedBoolean() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}