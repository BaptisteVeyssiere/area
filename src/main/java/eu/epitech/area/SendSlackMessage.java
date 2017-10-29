package eu.epitech.area;

import allbegray.slack.webapi.SlackWebApiClient;

import java.util.List;

public class SendSlackMessage extends IReaction {

    private SlackWebApiClient apiClient;

    public SendSlackMessage() {
        setName("Envoyer un message sur slack");
    }

    @Override
    public void execute(List<String> params) {
        try {
            apiClient.postMessage("area", params.get(0));
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void setAccess(Object o) {
        try {
            apiClient = (SlackWebApiClient) o;
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
