package com.plsr.sunil.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by sunil on 2/25/18.
 */

/**
 * how to create custom classes with Mockito.any()
 */
public class UserRegistrationTest2 {

    private UserRegistration testee;
    private Database mockDatabase;
    private EmailSender mockEmailSender;

    @Before
    public void setup() {

        mockDatabase = Mockito.mock(Database.class);
        mockEmailSender = Mockito.mock(EmailSender.class);
        testee = new UserRegistration(mockDatabase, mockEmailSender);
    }

    @Test
    public void shouldAddNewUserToDatabaseAndSendRegistrationEmail() throws Exception {

        when(mockDatabase.hasUser(anyString())).thenReturn(false);

        when(mockEmailSender.sendRegistrationEmail((RegistrationEmail)Mockito.any())).thenReturn(true);

        testee.registerNewUserAndSendRegistrationEmail("lpalaku1@uncc.edu");

        verify(mockDatabase).addUser("lpalaku1@uncc.edu");
    }


    @Test
    public void shouldNotDropDatabaseWhenDeletingUsers() throws Exception {
        testee.deleteUser("A@as.com");

        //below line will fail because dropDatabase is not even called once
        //verify(mockDatabase).dropDatabase();

        //to verify a method is called zer times below implementation of verify should be used
        verify(mockDatabase, times(0)).dropDatabase();

        /*
        Other options of verify
        verify(mockDatabase, never()).dropDatabase();
        verify(mockDatabase, atLeast(5)).dropDatabase();
        verify(mockDatabase, atMost(4)).dropDatabase();
        */
    }

}