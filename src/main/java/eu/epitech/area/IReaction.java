package eu.epitech.area;

public abstract class IReaction {
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void  execute();
}
