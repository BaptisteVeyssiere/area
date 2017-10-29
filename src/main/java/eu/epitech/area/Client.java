package eu.epitech.area;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Client implements Serializable {

    private String   username;
    private List<IModule>   modules = new LinkedList<IModule>();
    private List<String[]>  links = new LinkedList<>();

    public Client()
    {
    }

    public Client(String username_) {
            username = username_;
    }

    public List<IModule> getModules() {
        return modules;
    }

    public void setModules(List<IModule> modules) {
        this.modules = modules;
    }

    public void addModule(IModule module) {
        modules.add(module);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLinks(List<String[]> links) {
        this.links = links;
    }

    public List<String[]> getLinks() {
        return links;
    }

    public void addLink(String actionmodule, String action, String reactionmodule, String reaction) {
        links.add(new String[]{actionmodule, action, reactionmodule, reaction});
    }

    public IModule  getModuleByName(String name) {
        for (IModule module : modules) {
            if (module.getName().equals(name))
                return (module);
        }
        return (null);
    }
}
