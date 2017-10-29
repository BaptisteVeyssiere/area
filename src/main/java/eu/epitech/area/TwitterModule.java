package eu.epitech.area;

import twitter4j.Twitter;

import java.util.LinkedList;
import java.util.List;

public class TwitterModule extends IModule {
    private Twitter twitter = null;

    public  TwitterModule() {
        List<ITrigger> triggers = new LinkedList<ITrigger>();
        List<IReaction>  reactions = new LinkedList<IReaction>();

        setName("Twitter");
        triggers.add(new GetUserTweets(twitter));
        setReactions(reactions);
        setTriggers(triggers);
    }

    public String   getLink() {
        return ("lol");
    }
}
