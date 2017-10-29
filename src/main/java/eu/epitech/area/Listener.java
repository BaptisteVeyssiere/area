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
                boolean status = false;

                while ((Boolean)servletContextEvent.getServletContext().getAttribute("running")) {
                    for (Client client : ((Core)servletContextEvent.getServletContext().getAttribute("core")).getClients()) {
                        for (String[] link : client.getLinks()) {
                            for (ITrigger trigger : client.getModuleByName(link[0]).getTriggers()) {
                                if (trigger.getName().equals(link[1])) {
                                    status =  trigger.isTriggered();
                                    System.out.println("Trigger");
                                    for (IReaction reaction : client.getModuleByName(link[2]).getReactions()) {
                                        System.out.println("Reaction execution");
                                    }
                                }
                            }
                        }
                    }
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