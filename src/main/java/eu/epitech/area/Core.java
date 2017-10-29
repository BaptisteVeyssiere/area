package eu.epitech.area;

import javax.servlet.ServletContextEvent;
import java.util.LinkedList;
import java.util.List;

public class Core {

    List<IModule>       modules = new LinkedList<IModule>();
    List<Client>        clients = new LinkedList<Client>();
    ServletContextEvent context;

    public Core(ServletContextEvent contextEvent) {
        context = contextEvent;
        modules.add(new SlackModule());
        modules.add(new TwitterModule());
    }

    public void setModules(List<IModule> modules) {
        this.modules = modules;
    }

    public List<IModule> getModules() {
        return modules;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}
