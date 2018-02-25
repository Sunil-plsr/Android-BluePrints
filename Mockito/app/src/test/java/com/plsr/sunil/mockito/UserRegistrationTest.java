package com.plsr.sunil.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

/**
 * Created by sunil on 2/25/18.
 */


/**
 * This test class is only to test the functionality of UserRegistration class, therefore we mock its
 * dependency class i.e Database
 */

public class UserRegistrationTest {

    private UserRegistration testee;
    private Database mockDatabase;

    @Before
    public void setup() {

        mockDatabase = Mockito.mock(Database.class);
        testee = new UserRegistration(mockDatabase);
    }

    @Test (expected = Exception.class)
    public void shouldThrowExceptionWhenUserIsAlreadyRegistered() throws Exception {

        /**
         *we are mocking hasUser method of database object which will be called when registerNewUser
         * is called so that it will retuen true for any string value passed.
         */

        Mockito.when(mockDatabase.hasUser(anyString())).thenReturn(true);
        /* below two methods also does the same thing as above statement, but the sytax is different
        Mockito.doReturn(true).when(mockDatabase.hasUser(anyString()));
        Mockito.doReturn(true).when(mockDatabase).hasUser(anyString());
        */
        //in the above line mockDatabase acts as an TestDouble of type Stub
        //A test double is called as an stub when it produces hardcoded responses to inputs


        testee.registerNewUser("plsr.sunil@gmail.com");

    }



    @Test
    public void shouldAddNewUserToDatabase() throws Exception {

        //Here mockDatabase TestDouble acts as an STUB
        Mockito.when(mockDatabase.hasUser(anyString())).thenReturn(false);


        /*
            Mockito.when(mockDatabase.hasUser((String) ArgumentMatchers.any())).thenReturn(false);
            ArgumentMatchers.any() should be used, when we want the mock method to respond to null string also.
         */

        testee.registerNewUser("lpalaku1@uncc.edu");

        //here mockDatabase TestDouble acts as a Mock
        Mockito.verify(mockDatabase).addUser("lpalaku1@uncc.edu");
        //Mockito.verify verifys that the addUser method of mockDatabase is called
    }

    @Test (expected = Exception.class)
    public void shouldThrowExceptionDeletingUserNotInDatabase() throws Exception {

        /*
        Mockito.when(mockDatabase.deleteUser("asda@asd.com")).thenThrow(Exception.class);
        above syntax cannot be applied to methods returning void
         */

        /*
        Mockito.when() cannot be used when there is a void return tyoe for a function, for stubbing
        such kind of methods we can use Mockito.doRetrun().when()

        ex:
        Mockito.doReturn(null)
         */

        Mockito.doReturn(Exception.class).when(mockDatabase).deleteUser(anyString());

        testee.deleteUser("adad@asd.com");

    }

}