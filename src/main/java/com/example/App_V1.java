package com.example;

import twitter4j.*;
import twitter4j.conf.*;

public class App_V1 {
    public static void main(String[] args) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("K9LOlayaRsekfnmmcseWry8ge")
                .setOAuthConsumerSecret("YgX0zzjzXgyyg3F9CwPMdpo6fHgY4bmbserE1QIGMX5Nul9xV4")
                .setOAuthAccessToken("79032852-EjO6Og4fsyVDWnfI4QwfrGwL5twdW7nuo3Nx4i45r")
                .setOAuthAccessTokenSecret("XZtsDkHBClph2qQ6afCjhOefPJXtz81NduXzegpYslIWv");

        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        try {
            // Ejemplo: Publicar un tweet
            Status status = twitter.updateStatus("¡Hola, Twitter desde Java!");

            System.out.println("Tweet publicado: " + status.getText());
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}

