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
    }

    public void setModules(List<IModule> modules) {
        this.modules = modules;
    }

    public List<IModule> getModules() {
        return modules;
    }
}
