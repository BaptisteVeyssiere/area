package eu.epitech.area;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;

import java.util.LinkedList;
import java.util.List;

public class SlackModule extends IModule {

    private SlackWebApiClient apiClient;

    public  SlackModule() {
        List<ITrigger>   triggers = new LinkedList<ITrigger>();
        List<IReaction>  reactions = new LinkedList<IReaction>();

        setName("Slack");
        reactions.add(new SendSlackMessage());
        setReactions(reactions);
        setTriggers(triggers);
    }

    public void setToken(String val)
    {

    }

    public String   getParameter()
    {
        return (getName() + "/code");
    }

    public String   getLink() {
        return ("https://slack.com/oauth/authorize?&client_id=261529746561.261980120307&scope=incoming-webhook,channels:history,channels:read,channels:write&redirect_uri=http://localhost:8080/modules");
    }
}
