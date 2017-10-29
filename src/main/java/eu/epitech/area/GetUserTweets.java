package eu.epitech.area;

import twitter4j.*;

import java.util.List;

public class GetUserTweets extends ITrigger{

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
    public boolean isTriggered() {
        if (username == null) {
            try {
                getUserInfo();
            } catch (twitter4j.TwitterException e) {
                return (false);
            }
        }

        boolean trigger = false;
        try {
            List<Status> tweets = getTweets();
            if (tweets == null)
                return (false);
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
            return (false);
        }
        return (trigger);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
