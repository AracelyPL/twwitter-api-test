package com.example;

import java.util.List;
import java.util.Scanner;

import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class App_V2 {
    public static void main(String[] args) {
        int op;
        Scanner sca = new Scanner(System.in);

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("K9LOlayaRsekfnmmcseWry8ge")
                .setOAuthConsumerSecret("YgX0zzjzXgyyg3F9CwPMdpo6fHgY4bmbserE1QIGMX5Nul9xV4")
                .setOAuthAccessToken("79032852-EjO6Og4fsyVDWnfI4QwfrGwL5twdW7nuo3Nx4i45r")
                .setOAuthAccessTokenSecret("XZtsDkHBClph2qQ6afCjhOefPJXtz81NduXzegpYslIWv");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            // Conexión establecida
            System.out.println("Conexión exitosa con la API de Twitter");
                  
        } catch (TwitterException e){ 
            e.printStackTrace();
        }
    }
}
