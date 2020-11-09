/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sasha
 */
public class MainServer {
    ServerSocket server;
    Socket msocket;
    BufferedReader in;
    DataOutputStream out;
    public Socket attendi() {
        try {
            //creo il server sulla porta ****
            System.out.println("Server in esecuzione..");
            server = new ServerSocket(1122);

            //accetto eventuale connessione da parte del client
            msocket = server.accept();
            System.out.println("Client connesso con successo! ");

            //chiudo la connessione per evitare altre connessioni
            server.close();

            //inizializzo gli stream per consentire la comunicazione
            out = new DataOutputStream(msocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(msocket.getInputStream()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza del server");
            System.exit(1);
        }
        return msocket;
    }


    public void calcola(){
        try{
            double x;
            double y;
            double risultato=0;
            //leggo la scelta e in base a quella eseguo le operazioni
            int scelta = in.read();

            //accetto prima i numeri
            x = in.read();

            System.out.println("x "+x);
            y = in.read();
            System.out.println("y "+y);

            switch (scelta){
                case 1:
                    System.out.println("Scelta: "+scelta);
                    //somma
                    risultato = x+y;


            }
            System.out.println("Risultato: "+risultato);

        }catch (Exception e){

        }
    }


    public static void main(String args[]) {
        MainServer myServer = new MainServer();
        myServer.attendi();
        myServer.calcola();
    }
}
