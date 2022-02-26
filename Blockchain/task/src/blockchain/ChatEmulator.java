package blockchain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ChatEmulator {
    private static ChatEmulator instance = new ChatEmulator();
    List<String> botNames = List.of("Kate", "Tom", "Nick", "Alex", "John");
    int threads = 4;
    Set<MessageBot> bots;
    ExecutorService executorService;

    public static ChatEmulator getInstance() {
        return instance;
    }

    void haveChatAt(BlockChain blockChain) {
        bots = new HashSet<>();
        executorService = Executors.newFixedThreadPool(threads);
        botNames.forEach(bot -> bots.add(new MessageBot(bot, blockChain)));
        bots.forEach(executorService::submit);

    }

    private ChatEmulator() {
    }

    void stop() {
        bots.forEach(MessageBot::stop);
        executorService.shutdown();
    }
}