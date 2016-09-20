package com.example.saneef.recyclerview;

/**
 * Created by saneef on 7/9/16.
 */
public class Person {
    String displayName;
    String emailAddress;

    public Person()
    {

    }

    public Person(String displayName, String emailAddress) {
        this.displayName = displayName;
        this.emailAddress = emailAddress;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
