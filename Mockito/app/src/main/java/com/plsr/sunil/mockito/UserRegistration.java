package com.plsr.sunil.mockito;

/**
 * Created by sunil on 2/25/18.
 */

public class UserRegistration {

    private Database database;
    private EmailSender emailSender;

    public UserRegistration(Database database, EmailSender emailSender) {
        this.database = database;
        this.emailSender = emailSender;
    }

    public UserRegistration(Database database) {
        this.database = database;
        this.emailSender = null;
    }

    public void registerNewUser(String emailAddress) throws Exception {
        if (database.hasUser(emailAddress))
            throw new Exception();
        else {
            database.addUser(emailAddress);
        }

    }
    public void registerNewUserAndSendRegistrationEmail(String emailAddress) throws Exception {
        if (database.hasUser(emailAddress))
            throw new Exception();
        else {
            database.addUser(emailAddress);

            if (!emailSender.sendRegistrationEmail(new RegistrationEmail(emailAddress))) {
                throw new ExceptionInInitializerError();
            }

        }

    }

    public void deleteUser(String emailAddress) throws Exception{
        database.deleteUser(emailAddress);
    }
}
