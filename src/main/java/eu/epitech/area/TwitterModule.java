package eu.epitech.area;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

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
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setOAuthConsumerKey("ZVhu7BPEbh9TaTQDLVUVvC0lO");
        cb.setOAuthConsumerSecret("dNhGF4xlQWtiCQctF16DWufOpFWF9a1YsFEx0qXkAARaB2x9kw");
        twitter = new TwitterFactory(cb.build()).getInstance();
        try {
            requestToken = twitter.getOAuthRequestToken("http://localhost:8080/modules");
        } catch (twitter4j.TwitterException e) {
            return ("nope");
        }
        return (requestToken.getAuthenticationURL());
    }

    public String   getParameter() {
        return ("oauth_verifier");
    }

    public void     setToken(String token) {
        try {
            AccessToken at = twitter.getOAuthAccessToken(requestToken, token);
            twitter.setOAuthAccessToken(at);
            for (ITrigger trig : getTriggers()) {
                trig.setAccess(twitter);
            }
        } catch (twitter4j.TwitterException e) {
            System.out.println("Failed to authenticate twitter user");
            return ;
        }
    }
}
