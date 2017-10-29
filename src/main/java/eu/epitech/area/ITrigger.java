package eu.epitech.area;

import java.util.List;

public abstract class ITrigger {
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract List<String> getMessage();

    public abstract boolean getStatus();

    public abstract void  isTriggered();

    public abstract void setAccess(Object o);

}
