package com.plsr.sunil.mockito;

/**
 * Created by sunil on 2/25/18.
 */

public class Database {

    /**
     * This is a parent class, in reality this will have the code to interact with the database
     * For this project purposes, UserRegistration class will use this class, but while testing
     * the functionality of this class will be mocked
     */


    //these are dummy methods and will be mocked while testing
    public void addUser(String emailAddress) {
    }

    public boolean hasUser(String emailAddress) {
        return true;
    }

    public void deleteUser(String emailAddress) {
    }

    public void dropDatabase() {
    }
}
