package eu.epitech.area;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.util.LinkedList;
import java.util.List;

public class TwitterModule extends IModule {
    private Twitter twitter = null;
    private AccessToken acessToken;
    private RequestToken requestToken;

    public  TwitterModule() {
        List<ITrigger> triggers = new LinkedList<ITrigger>();
        List<IReaction>  reactions = new LinkedList<IReaction>();

        setName("Twitter");
        triggers.add(new GetUserTweets(twitter));
        setReactions(reactions);
        setTriggers(triggers);
    }

    public String   getLink() {
        twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("ZVhu7BPEbh9TaTQDLVUVvC0lO", " dNhGF4xlQWtiCQctF16DWufOpFWF9a1YsFEx0qXkAARaB2x9kw");
        try {
            requestToken = twitter.getOAuthRequestToken("http://localhost:8080/module");
        } catch (twitter4j.TwitterException e) {
            return (null);
        }
        return (requestToken.getAuthenticationURL());
    }
}