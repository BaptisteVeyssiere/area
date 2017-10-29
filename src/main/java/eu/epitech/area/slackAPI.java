package eu.epitech.area;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.type.Channel;
import allbegray.slack.type.History;
import allbegray.slack.webapi.SlackWebApiClient;

import java.util.List;

public class slackAPI {

    private SlackWebApiClient apiClient;

    public slackAPI(String token) {
        apiClient = SlackClientFactory.createWebApiClient(token);
    }

    public void createChannel(String channel)
    {
        apiClient.createChannel(channel);
    }

    //Need "channels:write" permission
    public void sendMessage(String channel, String message)
    {
        apiClient.postMessage(channel, message);
    }

}
