package eu.epitech.area;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Listener implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
        servletContextEvent.getServletContext().setAttribute("running", true);
        Thread thread = new Thread("Backloop Thread") {
            public void run() {
                ServletContextEvent tmp = servletContextEvent;
                while ((Boolean)servletContextEvent.getServletContext().getAttribute("running")) {
                    System.out.println("run by: " + getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                    tmp.getServletContext().setAttribute("end", "The end of times");
                }
                System.out.println("Fin du Thread");
            }
        };
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent.getServletContext().getAttribute("end"));
        servletContextEvent.getServletContext().setAttribute("running", false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}