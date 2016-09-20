package com.example.saneef.loginapp;

/**
 * Created by saneef on 1/9/16.
 */
public class Person
{
    private String personName;
    private String userName;
    private String password;

 /*   public Person(String personName,String userName,String password)
    {
        this.personName=personName;
        this.userName=userName;
        this.password=password;
    }*/

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPersonName()
    {
        return personName;
    }

    public String getUserName()
    {
          return userName;
    }
}
