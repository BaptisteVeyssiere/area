package eu.epitech.area;

import java.util.List;

public abstract class IModule {
    private List<ITrigger>   triggers;
    private List<IReaction>  reactions;
    private String           name;

    public List<IReaction> getReactions() {
        return reactions;
    }

    public List<ITrigger> getTriggers() {
        return triggers;
    }

    public void setReactions(List<IReaction> reactions) {
        this.reactions = reactions;
    }

    public void setTriggers(List<ITrigger> triggers) {
        this.triggers = triggers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String   getLink();
}
