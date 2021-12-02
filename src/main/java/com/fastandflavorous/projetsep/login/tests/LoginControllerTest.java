package com.fastandflavorous.projetsep.login.tests;

import com.fastandflavorous.projetsep.LoginController;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class LoginControllerTest {

    LoginController lc = new LoginController();

    @Test
    @DisplayName("Checking if token 'fastAndFlavorous' is regognised :")
    public void clientLoginTestTrue() {
        assertEquals(true, lc.clientLogin("fastAndFlavorous"));
    }
    @Test
    @DisplayName("Checking if token 'meWantFood' is rejected :")
    public void clientLoginTestFalse() {
        assertEquals(false, lc.clientLogin("meWantFood"));
    }

    @Test
    @DisplayName("Checking if employee 'fast@fast.com' with password 'fast' is recognised :")
    public void employeeLoginTestTrue() {
        assertEquals(true, lc.employeeLogin("fast@fast.com", "fast"));
    }
    @Test
    @DisplayName("Checking if employee 'hacker@hacking.com' with password 'fast' is rejected :")
    public void employeeLoginTestFalse() {
        assertEquals(false, lc.employeeLogin("hacker@hacking.com", "fast"));
    }
    @Test
    @DisplayName("Checking if employee 'fast@fast.com' with password 'wrong' is rejected :")
    public void employeeLoginTestWrongPswd() {
        assertEquals(false, lc.employeeLogin("fast@fast.com", "wrong"));
    }
}