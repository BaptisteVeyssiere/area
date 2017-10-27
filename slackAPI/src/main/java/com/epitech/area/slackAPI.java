package com.epitech.area;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;

public class slackAPI {

    private SlackWebApiClient apiClient;

    public slackAPI(String token) {
        apiClient = SlackClientFactory.createWebApiClient(token);
    }

    public void createChannel(String channel)
    {
        apiClient.createChannel(channel);
    }

    public void sendMessage(String channel, String message)
    {
        apiClient.postMessage(channel, message);
    }
}
