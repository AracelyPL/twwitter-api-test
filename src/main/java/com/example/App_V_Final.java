package com.example;

import java.util.List;
import java.util.Scanner;

import twitter4j.*;
import twitter4j.conf.*;

public class App_V_Final {
   
    public static void main(String[] args) {
        int op;
        Scanner scan = new Scanner(System.in);

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


            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Mostrar la lista de tweets de un usuario");
            System.out.println("2. Publicar un nuevo tweet");
            System.out.println("3. Eliminar un tweet");

            System.out.print("Que opción desea realizar: ");
            op = scan.nextInt();
            scan.nextLine();

            switch(op){
                case 1:
                    System.out.println("------ MOSTRAR LISTA DE TWEETS DE UN USUARIO ------ \n");
                    // Mostrar lista de tweets de un usuario
                    System.out.println("Nombre del usuario: ");
                    String username = scan.nextLine();


                    Paging paging = new Paging(1, 10); // Número de página y cantidad de tweets a obtener
                    List<Status> userTimeline = twitter.getUserTimeline(username, paging);
                    System.out.println("Tweets de @" + username + ":");
                    for (Status status : userTimeline) {
                        System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText());
                    }
                    break;

                case 2:
                    System.out.println("------ PUBLICAR UN NUEVO TWEET ------ \n");
                    // Publicar un nuevo tweet
                    System.out.println("Escribe el mensaje: ");
                    String tweetText = scan.nextLine();

                    Status status = twitter.updateStatus(tweetText);
                    System.out.println("Nuevo tweet publicado: " + status.getText());
                    break;
                    
                case 3:
                    System.out.println("------ ELIMINAR UN TWEET ------ \n");
                    // Eliminar un tweet
                    System.out.print("Ingrese un número: ");
                    long numero = scan.nextLong();
                    twitter.destroyStatus(numero);
                    System.out.println("Tweet eliminado con éxito.");
                break;
            }
            
        } catch (Exception e){ 
            e.printStackTrace();

        }
    }
}