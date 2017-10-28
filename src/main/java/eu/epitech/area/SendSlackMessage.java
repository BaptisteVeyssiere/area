package eu.epitech.area;

public class SendSlackMessage extends ITrigger {

    public SendSlackMessage() {
        setName("Envoyer un message sur slack");
    }

    @Override
    public boolean isTriggered() {
        return false;
    }
}
