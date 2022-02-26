package blockchain;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageSender implements Runnable {
    private final List<Map.Entry<String, String>> textMessages = List.of(
            Map.entry("Tom", "Hey, I'm first!"),
            Map.entry("Sarah", "It's not fair!"),
            Map.entry("Sarah", "You always will be first because it is your blockchain!"),
            Map.entry("Sarah", "Anyway, thank you for this amazing chat."),
            Map.entry("Tom", "You're welcome :)"),
            Map.entry("Nick", "Hey Tom, nice chat"),
            Map.entry("Nick", "How did you do that?"),
            Map.entry("Tom", "Well, I asked Vladimir"),
            Map.entry("Tom", "You know him, right?"),
            Map.entry("Sarah", "Blah blah blah"),
            Map.entry("Nick", "Really? Oh wow"),
            Map.entry("Tom", "Yeah and blah blah blah...")
    );

    @Override
    public void run() {
        Random rand = new Random();
        textMessages.forEach(
                message -> {
                    try {
                        TimeUnit.SECONDS.sleep(rand.nextInt(4));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    BotUser.getBotUser(message.getKey())
                            .sendMessage(message.getValue());
                }
        );
    }
}