package main;

import org.eclipse.jetty.server.Server;

/**
 * Created by timur on 29.01.16.
 */
public class Main {
    public static void main(String[] args){

        Server server = new Server(8080);

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
