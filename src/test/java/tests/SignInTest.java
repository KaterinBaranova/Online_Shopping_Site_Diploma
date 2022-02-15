package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    private SignInPage signInPage;


    @BeforeMethod
    public void navigate() {
        signInPage = new SignInPage (driver);
    }

    private final static String INVALID_USERNAME = "Katee1@test2.com";
    private final static String INVALID_PASSWORD = "1234";


    @Test(description = "Login with valid credentials", groups = {"Smoke Test"})
    public void signInPositiveTest() {
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        assertTrue(signInPage.isSignOutLinkDisplayed(), "Sign out link is not displayed on the page");
    }

    @Test(description = "Login with empty email field", groups = {"Regression Test"})
    public void signInWithEmptyLoginTest() {
        String expected_error_message = "An email address required.";
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(" ", PASSWORD);
        Assert.assertTrue(signInPage.isErrorMessageDisplayed(), expected_error_message);
    }

    @Test(description = "Login with empty password field", groups = {"Regression Test"})
    public void signInWithEmptyPasswordTest() {
        String expected_error_message = "Password is required.";
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, " ");
        Assert.assertTrue(signInPage.isErrorMessageDisplayed(), expected_error_message);
    }

    @Test(description = "Login with invalid credentials", groups = {"Smoke Test"})
    public void signInWithInvalidCredentialsTest() {
        String expected_error_message = "Authentication failed.";
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(INVALID_USERNAME, INVALID_PASSWORD);
        Assert.assertTrue(signInPage.isErrorMessageDisplayed(), expected_error_message);
    }

    @Test(description = "User is able to log out from app", groups = {"Smoke Test"})
    public void signOutTest() {
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        signInPage.signOut();
        assertTrue(signInPage.isSignInLinkDisplayed(),"SignIn link was not displayed after sign out action");}
}

