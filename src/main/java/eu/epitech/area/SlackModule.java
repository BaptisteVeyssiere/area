package eu.epitech.area;

import java.util.LinkedList;
import java.util.List;

public class SlackModule extends IModule {
    public  SlackModule() {
        List<ITrigger>   triggers = new LinkedList<ITrigger>();
        List<IReaction>  reactions = new LinkedList<IReaction>();

        setName("Slack");
        triggers.add(new SendSlackMessage());
        setReactions(reactions);
        setTriggers(triggers);
    }
}
