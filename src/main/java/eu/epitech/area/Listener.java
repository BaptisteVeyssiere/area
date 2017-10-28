package eu.epitech.area;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

public class Listener implements ServletContextListener {

    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("core", new Core(servletContextEvent));
        servletContextEvent.getServletContext().setAttribute("running", true);
        Thread thread = new Thread("Backloop Thread") {
            public void run() {
                while ((Boolean)servletContextEvent.getServletContext().getAttribute("running")) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
                System.out.println("Fin du Thread");
            }
        };
        thread.start();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("running", false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}