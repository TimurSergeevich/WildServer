package main;

import api.v1.jersey.User;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import servlets.AuthServlet;

/**
 * Created by timur on 29.01.16.
 */
public class Main {
    public static void main(String[] args){

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //context.setContextPath("/");
        context.addServlet(new ServletHolder(new AuthServlet()),"/*");

        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/api/v1/*");
        servletHolder.setInitParameter(
                "jersey.config.server.provider.classnames",
                User.class.getCanonicalName());
System.out.println(User.class.getCanonicalName());

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
