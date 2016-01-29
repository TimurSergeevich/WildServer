package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import servlets.StartPage;

import javax.servlet.Servlet;
import java.net.MalformedURLException;

/**
 * Created by timur on 29.01.16.
 */
public class Main {
    public static void main(String[] args){

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/main");
        context.addServlet(new ServletHolder(new StartPage()),"/start");

        Server server = new Server(8080);
        server.setHandler(context);

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
