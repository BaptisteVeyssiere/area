package eu.epitech.area;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Listener implements ServletContextListener {

    public void contextInitialized(final ServletContextEvent servletContextEvent) {
        try {
            UsersBean users = new UsersBean();
            XMLDecodeFromFile decoder = new XMLDecodeFromFile();
            users = decoder.DecodeUsersBean(users);}
        catch (Exception e)
        {
            System.err.println("Error: " + e);
        }
        servletContextEvent.getServletContext().setAttribute("core", new Core(servletContextEvent));
        servletContextEvent.getServletContext().setAttribute("running", true);
        Thread thread = new Thread("Backloop Thread") {
            public void run() {
                boolean status = false;

                while ((Boolean)servletContextEvent.getServletContext().getAttribute("running")) {
                    for (Client client : ((Core)servletContextEvent.getServletContext().getAttribute("core")).getClients()) {
                        for (IModule module : client.getModules()) {
                            for (ITrigger trigger : module.getTriggers()) {
                                trigger.isTriggered();
                            }
                        }
                        for (String[] link : client.getLinks()) {
                            for (ITrigger trigger : client.getModuleByName(link[0]).getTriggers()) {
                                if (trigger.getName().equals(link[1])) {
                                    if (trigger.getStatus()) {
                                        System.out.println("Trigger");
                                        for (IReaction reaction : client.getModuleByName(link[2]).getReactions()) {
                                            if (reaction.getName().equals(link[3])) {
                                                System.out.println("Reaction execution");
                                                //reaction.execute();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(10000);
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
        Core    core = (Core) servletContextEvent.getServletContext().getAttribute("core");
        LinkedList<Client> clients = (LinkedList<Client>) core.getClients();
        try {
            Thread.sleep(2000);
            XmlEncodeToFile encoder = new XmlEncodeToFile();
            UsersBean users = new UsersBean();
            users.setUsers(clients);
            System.out.println(clients.get(0).getUsername());
            encoder.EncodeUsersBean(users);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}