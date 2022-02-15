package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SignInPage;

import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    private SignInPage signInPage;

    @DataProvider(name = "Inputs for negative tests")
    public Object[][] inputForNegativeTests() {
        return new Object[][]{
                {"", PASSWORD,"An email address required." },
                {LOGIN, "", "Password is required."},
                {INVALID_USERNAME, INVALID_PASSWORD, "Authentication failed."},
        };
    }

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

    @Test(description = "Login with empty email field/ with empty password / with invalid credentials",groups = {"Regression Test"},dataProvider = "Inputs for negative tests")
    public void negativeSignInTests(String email, String password, String expectedErrorMessage) {
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(email,password);
        Assert.assertTrue(signInPage.isErrorMessageDisplayed(), expectedErrorMessage);
    }

    @Test(description = "User is able to log out from app", groups = {"Smoke Test"})
    public void signOutTest() {
        signInPage.clickSignInLink();
        signInPage.signInWithCredentials(LOGIN, PASSWORD);
        signInPage.signOut();
        assertTrue(signInPage.isSignInLinkDisplayed(),"SignIn link was not displayed after sign out action");}
}

