package eu.epitech.area;

import java.util.List;

public abstract class IReaction {
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void  execute(List<String> params);

    public abstract void setAccess(Object o);

}
