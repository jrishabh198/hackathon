package com.example.rj.socius;

/**
 * Created by shivam on 3/3/17.
 */

public class UserProfile {
    private static String USER_NAME = "";
    private static int NUM_OF_COINS;

    public static void setUserName(String name){
        USER_NAME = name;
    }

    public static void addCoins(int numOfCoinsAdded){
        NUM_OF_COINS += numOfCoinsAdded;
    }

    public static String getUserName(){
        return USER_NAME;
    }

    public static int getNumOfCoins(){
        return  NUM_OF_COINS;
    }

}
