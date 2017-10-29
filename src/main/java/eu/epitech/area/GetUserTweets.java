package eu.epitech.area;

import twitter4j.*;

import java.util.LinkedList;
import java.util.List;

public class GetUserTweets extends ITrigger{

    private boolean status = false;
    private Twitter twitter;
    java.util.Date last_tweet = null;
    String username = null;
    String message = null;

    public GetUserTweets(Twitter twit) {
        setName("Récupérer les tweets mentionnant l'utilisateur.");
        twitter = twit;
    }

    private List<Status> getTweets() throws TwitterException {
        Query query = new Query("@" + username);
        query.setCount(50);
        QueryResult result = twitter.search(query);
        return (result.getTweets());
    }

    private void getUserInfo() throws TwitterException {
        username = twitter.getScreenName();

        List<Status> tweets = getTweets();
        if (tweets != null) {
            last_tweet = tweets.get(0).getCreatedAt();
        }
    }

    @Override
    public void isTriggered() {
        if (username == null) {
            try {
                getUserInfo();
            } catch (twitter4j.TwitterException e) {
                status = false;
                return;
            }
        }

        boolean trigger = false;
        try {
            List<Status> tweets = getTweets();
            System.out.println(tweets.size());
            if (tweets == null) {
                status = false;
                return;
            }
            message = null;
            String url = null;
            for (Status st : tweets) {
                if (last_tweet == null || st.getCreatedAt().after(last_tweet)) {
                    trigger = true;
                    url = "https://twitter.com/" + st.getUser().getScreenName() + "/status/" + st.getId();
                    message += url + " ";
                }
            }
            last_tweet = tweets.get(0).getCreatedAt();
        } catch (twitter4j.TwitterException e) {
            status = false;
            return;
        }
        status = trigger;
    }

    @Override
    public List<String> getMessage() {
        List<String> list = new LinkedList<>();

        list.add(message);
        return (list);
    }

    @Override
    public boolean getStatus() {
        return (status);
    }

    public void setAccess(Object o) {
        twitter = (Twitter)o;
    }
}
