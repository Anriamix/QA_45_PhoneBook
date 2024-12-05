package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {

        int i = new Random().nextInt(1000);

        new HomePage(getDriver()).ClickBtnLoginHeader();
        new LoginPage(getDriver()).typeRigistrationForm
                ("frodo_baggins_" + i + "@gmail.com", "Password123!");

        Assert.assertTrue(new ContactsPage(getDriver()).isSignOutPresent());
    }

    @Test
    public void registrationNegativeTest() {

        int i = new Random().nextInt(1000);

        new HomePage(getDriver()).ClickBtnLoginHeader();
        new LoginPage(getDriver()).typeRigistrationForm
                ("frodo_baggins_" + i + "@gmail.com", "Password123");

        new LoginPage(getDriver()).closeAlert();


        Assert.assertTrue(new LoginPage(getDriver()).ValidateErrorMessageLogin("Registration failed"));




    }

}